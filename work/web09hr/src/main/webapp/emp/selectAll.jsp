<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "전체 직원 목록" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="e_searchList.do">
    <select name="searchKey">
        <option value="first_name">first_name</option>
        <option value="job_id">job_id</option>
    </select>
    <input type="text" name="searchWord">
    <input type="submit" value="검색">
</form>

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
        <c:forEach var="vo" items="${list}">
            <tr>
                <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
                <td>${vo.first_name}</td>
                <td>${vo.last_name}</td>
                <td>${vo.email}</td>
                <td>${vo.phone_number}</td>
                <td>${vo.hire_date}</td>
                <td>${vo.job_id}</td>
                <td>${vo.salary}</td>
                <td>${vo.commission_pct}</td>
                <td>${vo.manager_id}</td>
                <td>${vo.department_id}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
