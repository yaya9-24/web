package com.example.mini_03_shopping.product.controller;

import com.example.mini_03_shopping.product.model.ProductDAO;
import com.example.mini_03_shopping.product.model.ProductDAOimpl;
import com.example.mini_03_shopping.product.model.ProductVO;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet({"/json_p_selectOne.do","/json_p_selectAll.do"
        ,"/json_p_searchList.do"})
public class ProductRestController extends HttpServlet {

    ProductDAO dao = new ProductDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/json_p_selectAll.do")){
            List<ProductVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        } else if (sPath.equals("/json_p_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            ProductVO vo = new ProductVO();
            vo.setNum(Integer.parseInt(num));

            ProductVO vo2 = dao.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(vo2));
        } else if (sPath.equals("/json_p_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");

            System.out.println(searchKey);
            System.out.println(searchWord);

            List<ProductVO> list2 = dao.searchList(searchKey,searchWord);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list2));
        }
    }//end doGet
}
