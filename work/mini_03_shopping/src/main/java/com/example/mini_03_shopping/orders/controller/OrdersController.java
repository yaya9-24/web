package com.example.mini_03_shopping.orders.controller;

import com.example.mini_03_shopping.board.model.BoardDAO;
import com.example.mini_03_shopping.board.model.BoardDAOimpl;
import com.example.mini_03_shopping.board.model.BoardVO;
import com.example.mini_03_shopping.orders.model.OrdersDAO;
import com.example.mini_03_shopping.orders.model.OrdersDAOimpl;
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

@WebServlet({"/o_insert.do","/o_update.do","/o_delete.do"
        ,"/o_selectOne.do","/o_selectAll.do","/o_searchList.do"
        ,"/o_insertOK.do","/o_updateOK.do","/o_deleteOK.do"})
public class OrdersController extends HttpServlet {

    OrdersDAO dao = new OrdersDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/o_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("orders/insert.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/o_selectAll.do")){
            
            RequestDispatcher rd = request.getRequestDispatcher("orders/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/b_selectOne.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);
        }
    }//end doGet...

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
