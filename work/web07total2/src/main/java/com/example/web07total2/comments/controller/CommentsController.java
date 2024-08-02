package com.example.web07total2.comments.controller;

import com.example.web07total2.comments.model.CommentsDAO;
import com.example.web07total2.comments.model.CommentsDAOimpl;
import com.example.web07total2.comments.model.CommentsVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/c_insertOK.do","/c_deleteOK.do"})
public class CommentsController extends HttpServlet {

    CommentsDAO dao = new CommentsDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/c_insertOK.do")){

            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            String bnum = request.getParameter("bnum");

            System.out.println(content);
            System.out.println(writer);
            System.out.println(bnum);

            CommentsVO vo = new CommentsVO();
            vo.setContent(content);
            vo.setWriter(writer);
            vo.setBnum(Integer.parseInt(bnum));
            int result = dao.insert(vo);
            System.out.println("result:"+result);
            response.sendRedirect("b_selectOne.do?num="+bnum);
        } else if (sPath.equals("/c_deleteOK.do")){
            String num = request.getParameter("num");
            String bnum = request.getParameter("bnum");
            System.out.println(num);
            System.out.println(bnum);
            CommentsVO vo = new CommentsVO();
            vo.setNum(Integer.parseInt(num));

            int result = dao.delete(vo);
            System.out.println("result:"+result);
            response.sendRedirect("b_selectOne.do?num="+bnum);

        }

    }//end doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }//end doPost
}
