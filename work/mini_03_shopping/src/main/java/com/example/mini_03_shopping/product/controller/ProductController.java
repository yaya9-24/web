package com.example.mini_03_shopping.product.controller;


import com.example.mini_03_shopping.product.model.ProductDAO;
import com.example.mini_03_shopping.product.model.ProductDAOimpl;
import com.example.mini_03_shopping.product.model.ProductVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

@WebServlet({"/p_insert.do","/p_insertList.do","/p_update.do","/p_delete.do"
        ,"/p_selectOne.do","/p_selectAll.do","/p_searchList.do"
        ,"/p_insertOK.do","/p_updateOK.do","/p_deleteOK.do"})
public class ProductController extends HttpServlet {

    ProductDAO dao = new ProductDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/p_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("product/insert.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/p_selectAll.do")){
            RequestDispatcher rd = request.getRequestDispatcher("product/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/p_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            request.setAttribute("num",num);
            RequestDispatcher rd = request.getRequestDispatcher("product/selectOne.jsp");
            rd.forward(request,response);
        }
    }//end doGet...

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/p_insertOK.do")){
            String pname ="";
            String price = "";
            String imgName = "book1.png";

            if (JakartaServletFileUpload.isMultipartContent(request)){

                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                upload.setFileSizeMax(1024 * 1024 * 50);

                List<FileItem> items = upload.parseRequest(request);

                for (FileItem item: items) {
                    System.out.println(item);
                    if (item.isFormField()){
                        if (item.getFieldName().equals("pname")){
                            pname = item.getString(Charset.forName("utf-8"));
                        }
                        if (item.getFieldName().equals("price")) {
                            price = item.getString();
                        }
                    } else {
                        String originName = item.getName();

                        System.out.println("originName:"+originName);
                        System.out.println("originName.length():"+originName.length());

                        if (originName.length()>0){
                            String temp = originName.substring(0,originName.lastIndexOf("."))+"_"+System.currentTimeMillis();
                            String type = originName.substring(originName.lastIndexOf("."));
                            System.out.println(temp);
                            System.out.println(type);
                            imgName = temp+type;

                            String dir_path = request.getServletContext().getRealPath("/upload");
                            System.out.println(dir_path);

                            File f = new File(dir_path,imgName);

                            item.write(f.toPath());
                        }
                    }
                }
            }

            System.out.println("title:"+pname);
            System.out.println("content:"+price);
            System.out.println("imgName:"+imgName);

            ProductVO vo = new ProductVO();
            vo.setPname(pname);
            vo.setPrice(Integer.parseInt(price));
            vo.setImgName(imgName);

            int result = dao.insert(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("p_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("p_insert.do");
            }

        }
    }
}
