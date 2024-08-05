package com.example.web09hr.dept.controller;

import com.example.web09hr.dept.model.DeptDAO;
import com.example.web09hr.dept.model.DeptDAOimpl;
import com.example.web09hr.dept.model.DeptVO;
import com.example.web09hr.job.model.JobDAO;
import com.example.web09hr.job.model.JobDAOimpl;
import com.example.web09hr.job.model.JobVO;
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
            String job_id = request.getParameter("job_id");
            System.out.println(job_id);

//            DeptVO vo = new DeptVO();
//            vo.setDepartment_id(job_id);
//            JobVO vo2 = ddao.selectOne(vo);
//            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("job/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/j_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("job/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/j_selectOne.do")){
            String job_id = request.getParameter("job_id");
            System.out.println(job_id);

            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            JobVO vo2 = jdao.selectOne(vo);
            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("job/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/j_selectAll.do")){
            List<JobVO> list = jdao.selectAll();
            request.setAttribute("list",list);


            RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/j_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<JobVO> list = jdao.searchList(searchKey,searchWord);
            request.setAttribute("list",list);
            RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/j_insertOK.do")){
            String job_id = request.getParameter("job_id");
            String job_title = request.getParameter("job_title");
            String min_sal = request.getParameter("min_sal");
            String max_sal = request.getParameter("max_sal");

            System.out.println(job_id);
            System.out.println(job_title);
            System.out.println(min_sal);
            System.out.println(max_sal);

            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            vo.setJob_title(job_title);
            vo.setMin_salary(Integer.parseInt(min_sal));
            vo.setMax_salary(Integer.parseInt(max_sal));

            int result = jdao.insert(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("j_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("j_insert.do");
            }
        } else if (sPath.equals("/j_updateOK.do")) {
            String job_id = request.getParameter("job_id");
            String job_title = request.getParameter("job_title");
            String min_sal = request.getParameter("min_sal");
            String max_sal = request.getParameter("max_sal");

            System.out.println(job_id);
            System.out.println(job_title);
            System.out.println(min_sal);
            System.out.println(max_sal);

            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            vo.setJob_title(job_title);
            vo.setMin_salary(Integer.parseInt(min_sal));
            vo.setMax_salary(Integer.parseInt(max_sal));

            int result = jdao.update(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("j_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("j_insert.do");
            }
        } else if (sPath.equals("/j_deleteOK.do")) {
            String job_id = request.getParameter("job_id");
            System.out.println(job_id);

            JobVO vo = new JobVO();
            vo.setJob_id(job_id);

            int result = jdao.delete(vo);
            if (result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("j_selectAll.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("j_insert.do");
            }
        }
    }//end doGet

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}//end class
