package com.example.web08session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet({"/login.do","/loginOK.do","/logout.do"})
public class TestController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/login.do")){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/loginOK.do")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");

            System.out.println(id);
            System.out.println(pw);

            //dao.login(vo); // 로그인 성공실패 리턴 null
            //성공했다라고 가정
            HttpSession session = request.getSession();
            session.setAttribute("user_id",id); //el ${user_id}
            session.setAttribute("name","kim"); //el ${user_id}
            session.setMaxInactiveInterval(5*60); // 5분(새로고침으로 연장됨)


            //쿠키 : 클라이언트(웹사용자) 브라우저에 저장가능
            //쿠키생성 후 응답객체(response)에 추가하는 방식을 사용함.
            Cookie cookie = new Cookie("message","hello"); //쿠키생성
            cookie.setMaxAge(5); //5초만 유지(새로고침으로도 연장 안 됨)
            response.addCookie(cookie); // 응답객체(response)에 추가
            Cookie cookie2 = new Cookie("isChecked","true");
            cookie2.setMaxAge(10);
            response.addCookie(cookie2); // 응답객체(response)에 추가




            response.sendRedirect("home.do");
        } else if (sPath.equals("/logout.do")) {
            //로그아웃에 적용할 메소드들
            HttpSession session = request.getSession();
            session.removeAttribute("user_id"); //속성제거
            //session.invalidate(); //세션 제거

            response.sendRedirect("home.do");
        }
    }//end doGet


    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }//end doPost
}
