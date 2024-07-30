package com.example.web04member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/m_insert.do","/m_update.do","/m_delete.do"
        ,"/m_selectOne.do","/m_selectAll.do","/m_searchList.do"
        ,"/m_insertOK.do","/m_updateOK.do","/m_deleteOK.do","/m_selectAllOK.do"})
public class MemberController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/m_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_update.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_selectOne.do")){
            System.out.println(request.getParameter("num"));
            int num = Integer.parseInt(request.getParameter("num"));

            MemberVO vo2 = new MemberVO();
            vo2.setNum(num);
            vo2.setId("admin1");
            vo2.setPw("비번1");
            vo2.setName("홍길동1");
            vo2.setTel("010");
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_selectAll.do")){

            List<MemberVO> list = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                MemberVO vo2 = new MemberVO();
                vo2.setNum(i);
                vo2.setId("admin"+i);
                vo2.setPw("비번"+i);
                vo2.setName("홍길동"+i);
                vo2.setTel("010-4444-000"+i);
                list.add(vo2);
            }
            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_searchList.do")){
            System.out.println(request.getParameter("searchKey"));
            System.out.println(request.getParameter("search_word"));

            RequestDispatcher rd = request.getRequestDispatcher("member/searchList.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/m_insertOK.do")) {
            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("pw"));
            System.out.println(request.getParameter("name"));
            System.out.println(request.getParameter("tel"));
        }else if (sPath.equals("/m_updateOK.do")) {
            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("pw"));
            System.out.println(request.getParameter("name"));
            System.out.println(request.getParameter("tel"));
        }else if (sPath.equals("/m_deleteOK.do")) {

            System.out.println(request.getParameter("id"));

        }
    }

    public void doPost(HttpServletRequest request
            , HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }
    public void destroy() {
    }
}