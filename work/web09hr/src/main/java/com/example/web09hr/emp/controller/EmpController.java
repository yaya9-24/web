package com.example.web09hr.emp.controller;

import com.example.web09hr.emp.model.EmpDAO;
import com.example.web09hr.emp.model.EmpDAOimpl;
import com.example.web09hr.emp.model.EmpVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet({"/e_insert.do","/e_update.do","/e_delete.do"
        ,"/e_selectOne.do","/e_selectAll.do","/e_searchList.do"
        ,"/e_insertOK.do","/e_updateOK.do","/e_deleteOK.do"})
public class EmpController extends HttpServlet {

    EmpDAO edao = new EmpDAOimpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/e_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("emp/insert.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_update.do")) {
            String employee_id = request.getParameter("employee_id");
            System.out.println(employee_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(Integer.parseInt(employee_id));
            EmpVO vo2 = edao.selectOne(vo);
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/update.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("emp/delete.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_selectOne.do")) {
            String employee_id = request.getParameter("employee_id");
            System.out.println(employee_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(Integer.parseInt(employee_id));
            EmpVO vo2 = edao.selectOne(vo);
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectOne.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_selectAll.do")) {
            List<EmpVO> list = edao.selectAll();
            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");

            List<EmpVO> list = edao.searchList(searchKey,searchWord);
            request.setAttribute("list",list);
            
            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/e_insertOK.do")) {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone_number = request.getParameter("phone_number");
            String hire_date = request.getParameter("hire_date");
            String job_id = request.getParameter("job_id");
            String salary = request.getParameter("salary");
            String commission_pct = request.getParameter("commission_pct");
            String manager_id = request.getParameter("manager_id");
            String department_id = request.getParameter("department_id");

            EmpVO vo = new EmpVO();
            vo.setFirst_name(first_name);
            vo.setLast_name(last_name);
            vo.setEmail(email);
            vo.setPhone_number(phone_number);
            vo.setHire_date(Date.valueOf(hire_date));
            vo.setJob_id(job_id);
            vo.setSalary(Integer.parseInt(salary));
            vo.setCommission_pct(Double.parseDouble(commission_pct));
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setDepartment_id(Integer.parseInt(department_id));

            int result = edao.insert(vo);
            if (result ==1){
                System.out.println("insert successed...");
                response.sendRedirect("e_selectAll.do");
            }else {
                System.out.println("insert failed...");
                response.sendRedirect("e_insert.do");
            }
        } else if (sPath.equals("/e_updateOK.do")) {
            String employee_id = request.getParameter("employee_id");
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone_number = request.getParameter("phone_number");
            String hire_date = request.getParameter("hire_date");
            String job_id = request.getParameter("job_id");
            String salary = request.getParameter("salary");
            String commission_pct = request.getParameter("commission_pct");
            String manager_id = request.getParameter("manager_id");
            String department_id = request.getParameter("department_id");

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(Integer.parseInt(employee_id));
            vo.setFirst_name(first_name);
            vo.setLast_name(last_name);
            vo.setEmail(email);
            vo.setPhone_number(phone_number);
            vo.setHire_date(Date.valueOf(hire_date));
            vo.setJob_id(job_id);
            vo.setSalary(Integer.parseInt(salary));
            vo.setCommission_pct(Double.parseDouble(commission_pct));
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setDepartment_id(Integer.parseInt(department_id));

            int result = edao.update(vo);
            if (result ==1){
                System.out.println("update successed...");
                response.sendRedirect("e_selectAll.do");
            }else {
                System.out.println("update failed...");
                response.sendRedirect("e_update.do");
            }
        } else if (sPath.equals("/e_deleteOK.do")) {
            String employee_id = request.getParameter("employee_id");

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(Integer.parseInt(employee_id));

            int result = edao.delete(vo);
            if (result ==1){
                System.out.println("delete successed...");
                response.sendRedirect("e_selectAll.do");
            }else {
                System.out.println("delete failed...");
                response.sendRedirect("e_delete.do");
            }
        }
    }//end doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }//end doPost
}//end class
