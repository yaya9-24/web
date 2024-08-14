package com.example.mini_03_shopping.board.controller;

import com.example.mini_03_shopping.board.model.BoardDAO;
import com.example.mini_03_shopping.board.model.BoardDAOimpl;

import com.example.mini_03_shopping.board.model.BoardVO;
import com.example.mini_03_shopping.member.model.MemberVO;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/json_b_selectAll.do","/json_b_selectOne.do"
        ,"/json_b_searchList.do"})
public class BoardRestController extends HttpServlet {

    BoardDAO dao = new BoardDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/json_b_selectAll.do")){

            List<BoardVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        }
         else if (sPath.equals("/json_b_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2 = dao.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(vo2));
        }
        else if (sPath.equals("/json_m_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");

            System.out.println(searchKey);
            System.out.println(searchWord);

            List<BoardVO> list2 = dao.searchList(searchKey,searchWord);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list2));
        }
    }//end doGet
}

