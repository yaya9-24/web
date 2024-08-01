package com.example.web03board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/b_insert.do","/b_update.do","/b_delete.do"
        ,"/b_selectOne.do","/b_selectAll.do","/b_searchList.do"
        ,"/b_insertOK.do","/b_updateOK.do","/b_deleteOK.do","/b_selectAllOK.do"})
public class BoardController extends HttpServlet {

    //BoardDAO,BoardDAOimpl 생성하시고 각 메소드들을 해당 분기문에서 호출해서 로그출력하세요.
    BoardDAO dao = new BoardDAOimpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/b_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_update.do")){
            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(num);

            BoardVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectOne.do")){
            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(num);

            BoardVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectAll.do")){
            List<BoardVO> list = dao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String search_word =request.getParameter("search_word");
            System.out.println(searchKey);
            System.out.println(search_word);

            List<BoardVO> list = dao.searchList(searchKey,search_word);
            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_insertOK.do")){
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = dao.insert(vo);
            if (result ==1){
                System.out.println("insert successed..");
                response.sendRedirect("b_selectAll.do"); //서블릿패스
            }else {
                System.out.println("insert failed..");
                response.sendRedirect("b_insert.do"); //서블릿패스
            }
        }else if (sPath.equals("/b_updateOK.do")){
            String num = request.getParameter("num");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");

            System.out.println(num);
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = dao.update(vo);

            if (result ==1){
                System.out.println("update successed..");
                response.sendRedirect("b_selectOne.do?num="+num);
            }else {
                System.out.println("update failed");
                response.sendRedirect("b_update.do?num="+num);
            }
        }else if (sPath.equals("/b_deleteOK.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            int result = dao.delete(vo);
            if (result ==1){
                System.out.println("delete successed...");
                response.sendRedirect("b_selectAll.do");
            }else {
                System.out.println("delete failed...");
                response.sendRedirect("b_delete.do?num="+num);
            }
        }
    }//end doGet

    public void doPost(HttpServletRequest request
            , HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    } //end doPost
}