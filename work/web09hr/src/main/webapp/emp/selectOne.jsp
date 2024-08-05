<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "선택 직원 목록" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
    <thead>
        <th>EMPLOYEE_ID</th>
        <th>FIRST_NAME</th>
        <th>LAST_NAME</th>
        <th>EMAIL</th>
        <th>PHONE_NUMBER</th>
        <th>HIRE_DATE</th>
        <th>JOB_ID</th>
        <th>SALARY</th>
        <th>COMMISSION_PCT</th>
        <th>MANAGER_ID</th>
        <th>DEPARTMENT_ID</th>
    </thead>
    <tbody>
        <tr>
            <td>${vo2.employee_id}</td>
            <td>${vo2.first_name}</td>
            <td>${vo2.last_name}</td>
            <td>${vo2.email}</td>
            <td>${vo2.phone_number}</td>
            <td>${vo2.hire_date}</td>
            <td>${vo2.job_id}</td>
            <td>${vo2.salary}</td>
            <td>${vo2.commission_pct}</td>
            <td>${vo2.manager_id}</td>
            <td>${vo2.department_id}</td>
        </tr>
    </tbody>
</table>
<a href="e_update.do?employee_id=${vo2.employee_id}">수정하기</a>
<a href="e_delete.do?employee_id=${vo2.employee_id}">삭제하기</a>
</body>
</html>
