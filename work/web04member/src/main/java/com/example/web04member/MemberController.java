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

        MemberDAO dao = new MemberDAOimpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/m_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_update.do")){
            System.out.println(request.getParameter("num"));
            int num = Integer.parseInt(request.getParameter("num"));
            MemberVO vo = new MemberVO();
            vo.setNum(num);
            MemberVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_selectOne.do")){
            System.out.println(request.getParameter("num"));
            int num = Integer.parseInt(request.getParameter("num"));
            MemberVO vo = new MemberVO();
            vo.setNum(num);
            MemberVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_selectAll.do")){

            List<MemberVO> list = dao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/m_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> list = dao.searchList(searchKey,searchWord);

            request.setAttribute("list",list);
            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/m_insertOK.do")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = dao.insert(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("m_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("m_insert.do");
            }
        }else if (sPath.equals("/m_updateOK.do")) {
            String num = request.getParameter("num");
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            System.out.println(num);
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = dao.update(vo) ;
            if (result == 1){
                System.out.println("update successed...");
                response.sendRedirect("m_selectOne.do?num="+num);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("m_update.do?num="+num);
            }
        }else if (sPath.equals("/m_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            int result = dao.delete(vo) ;
            if (result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("m_selectAll.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("m_delete.do?num="+num);
            }
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