package com.example.mini_03_shopping.member.controller;

import com.example.mini_03_shopping.member.model.MemberDAO;
import com.example.mini_03_shopping.member.model.MemberDAOimpl;
import com.example.mini_03_shopping.member.model.MemberVO;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/json_m_selectAll.do","/m_idCheck.do","/json_m_selectOne.do"
        ,"/json_m_searchList.do"})
public class MemberRestController extends HttpServlet {

    MemberDAO dao = new MemberDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/json_m_selectAll.do")){

            List<MemberVO> list = dao.selectAll();

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list));
        } else if (sPath.equals("/m_idCheck.do")){
            String id = request.getParameter("id");
            System.out.println(id);

            MemberVO vo = new MemberVO();
            vo.setId(id);

            MemberVO vo2 = dao.idCheck(vo);
            Map<String,String> map = new HashMap<>();
            if (vo2==null){
                map.put("result","OK");
            }
            else {
                map.put("result","Not OK");
            }

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(map));
        } else if (sPath.equals("/json_m_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = dao.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(vo2));
        } else if (sPath.equals("/json_m_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");

            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> list2 = dao.searchList(searchKey,searchWord);

            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(list2));
        }
    }//end doGet
}
