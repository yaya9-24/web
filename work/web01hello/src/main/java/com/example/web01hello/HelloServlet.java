package com.example.web01hello;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet") // value = 이게 servlet path 이다!!!!
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() { //init()은 확정된 이름이다. 변경하면 안 된다.
        message = "Hello World!";
    }

    //doGet()도 마찬가지다. 변경하면 안 된다.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       /* response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter(); // 이 방식은 자주 안 쓰인다. 래스트풀-비동기용서버이다.
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/


        RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
        rd.forward(request,response);




    }//end doGet()

    public void destroy() {
    }
}