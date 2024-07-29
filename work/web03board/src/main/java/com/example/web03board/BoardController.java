package com.example.web03board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/b_insert.do","/b_update.do","/b_delete.do","/b_selectOne.do","/b_selectAll.do","/b_searchList.do"})
public class BoardController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/b_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_update.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectOne.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectAll.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_searchList.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/searchList.jsp");
            rd.forward(request,response);
        }
    }//end doGet
}
