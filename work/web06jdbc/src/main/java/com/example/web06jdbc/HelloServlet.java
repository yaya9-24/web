package com.example.web06jdbc;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conn successed...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //web04member프로젝트를 jdbc연동되도록 구현하세요.



    }

    public void destroy() {
    }
}