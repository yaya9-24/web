package com.example.web09hr.dept.controller;

import com.example.web09hr.dept.model.DeptDAO;
import com.example.web09hr.dept.model.DeptDAOimpl;
import com.example.web09hr.dept.model.DeptVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/d_insert.do","/d_update.do","/d_delete.do"
        ,"/d_selectOne.do","/d_selectAll.do","/d_searchList.do"
        ,"/d_insertOK.do","/d_updateOK.do","/d_deleteOK.do"})
public class DeptController extends HttpServlet {

    DeptDAO ddao = new DeptDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/d_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_update.do")){
            String department_id = request.getParameter("department_id");
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));
            DeptVO vo2 = ddao.selectOne(vo);
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_selectOne.do")){
            String department_id = request.getParameter("department_id");
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));
            DeptVO vo2 = ddao.selectOne(vo);
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_selectAll.do")){
            List<DeptVO> list = ddao.selectAll();
            request.setAttribute("list",list);


            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<DeptVO> list = ddao.searchList(searchKey,searchWord);
            request.setAttribute("list",list);
            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/d_insertOK.do")){
//            String department_id = request.getParameter("department_id");
            String department_name = request.getParameter("department_name");
            String manager_id = request.getParameter("manager_id");
            String location_id = request.getParameter("location_id");

//            System.out.println(department_id);
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);

            DeptVO vo = new DeptVO();
//            vo.setDepartment_id(Integer.parseInt(department_id));
            vo.setDepartment_name(department_name);
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setLocation_id(Integer.parseInt(location_id));

            int result = ddao.insert(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("d_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("d_insert.do");
            }
        } else if (sPath.equals("/d_updateOK.do")) {
            String department_id = request.getParameter("department_id");
            String department_name = request.getParameter("department_name");
            String manager_id = request.getParameter("manager_id");
            String location_id = request.getParameter("location_id");

            System.out.println(department_id);
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));
            vo.setDepartment_name(department_name);
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setLocation_id(Integer.parseInt(location_id));

            int result = ddao.update(vo);
            if (result == 1){
                System.out.println("update successed...");
                response.sendRedirect("d_selectAll.do");
            } else {
                System.out.println("update failed...");
                response.sendRedirect("d_update.do");
            }
        } else if (sPath.equals("/d_deleteOK.do")) {
            String department_id = request.getParameter("department_id");
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));

            int result = ddao.delete(vo);
            if (result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("d_selectAll.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("d_delete.do");
            }
        }
    }//end doGet

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}//end class
