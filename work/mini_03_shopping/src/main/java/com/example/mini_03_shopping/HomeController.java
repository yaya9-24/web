package com.example.mini_03_shopping;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/home.do")){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void destroy() {
    }
}