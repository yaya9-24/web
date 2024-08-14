package com.example.mini_03_shopping.board.controller;

import com.example.mini_03_shopping.board.model.BoardDAO;
import com.example.mini_03_shopping.board.model.BoardDAOimpl;
import com.example.mini_03_shopping.board.model.BoardVO;
import com.example.mini_03_shopping.member.model.MemberVO;
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
import java.nio.charset.Charset;
import java.util.List;

@WebServlet({"/b_insert.do","/b_update.do","/b_delete.do"
        ,"/b_selectOne.do","/b_selectAll.do","/b_searchList.do"
        ,"/b_insertOK.do","/b_updateOK.do","/b_deleteOK.do"})
public class BoardController extends HttpServlet {

    BoardDAO dao = new BoardDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/b_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/b_selectAll.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/b_selectOne.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/b_update.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2 = dao.selectOne(vo);
            request.setAttribute("vo2",vo2);
            RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }
    }//end doGet...

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/b_insertOK.do")){
            String title ="";
            String content = "";
            String writer = "";
            String imgName = "book1.png";

            if (JakartaServletFileUpload.isMultipartContent(request)){

                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                upload.setFileSizeMax(1024 * 1024 * 50);

                List<FileItem> items = upload.parseRequest(request);

                for (FileItem item: items) {
                    System.out.println(item);
                    if (item.isFormField()){
                        if (item.getFieldName().equals("title")){
                            title = item.getString();
                        }
                        if (item.getFieldName().equals("content")){
                            content = item.getString();
                        }
                        if (item.getFieldName().equals("writer")){
                            writer = item.getString(Charset.forName("utf-8"));
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

            System.out.println("title:"+title);
            System.out.println("content:"+content);
            System.out.println("writer:"+writer);
            System.out.println("imgName:"+imgName);

            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setImgName(imgName);

            int result = dao.insert(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("b_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("b_insert.do");
            }

        } else if(sPath.equals("/b_updateOK.do")){
            String num ="";
            String title ="";
            String content = "";
            String writer = "";
            String imgName = "book1.png";

            if (JakartaServletFileUpload.isMultipartContent(request)){

                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                upload.setFileSizeMax(1024 * 1024 * 50);

                List<FileItem> items = upload.parseRequest(request);

                for (FileItem item: items) {
                    System.out.println(item);
                    if (item.isFormField()){
                        if (item.getFieldName().equals("num")){
                            num = item.getString();
                        }
                        if (item.getFieldName().equals("title")){
                            title = item.getString();
                        }
                        if (item.getFieldName().equals("content")){
                            content = item.getString();
                        }
                        if (item.getFieldName().equals("writer")){
                            writer = item.getString(Charset.forName("utf-8"));
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
            System.out.println("num:"+num);
            System.out.println("title:"+title);
            System.out.println("content:"+content);
            System.out.println("writer:"+writer);
            System.out.println("imgName:"+imgName);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setImgName(imgName);

            int result = dao.update(vo);
            if (result == 1){
                System.out.println("update successed...");
                response.sendRedirect("b_selectOne.do?num="+num);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("b_update.do");
            }
        } else if (sPath.equals("/b_deleteOK.do")){
            String num = request.getParameter("num2");

            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            int result = dao.delete(vo);
            if (result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("b_selectAll.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("b_update.do");
            }
        }
    }
}
