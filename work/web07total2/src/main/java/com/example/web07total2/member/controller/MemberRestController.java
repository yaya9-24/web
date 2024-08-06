package com.example.web07total2.member.controller;

import com.example.web07total2.member.model.MemberVO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

@WebServlet("/m_idCheck.do")
public class MemberRestController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/m_idCheck.do")){
            String id = request.getParameter("id");
            System.out.println(id);
            MemberVO vo = new MemberVO();
            vo.setId(id);

            Map<String,String> map = new HashMap<>();

        }


    }//end doGet


}
