<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "선택한 부서" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<table border="1">
    <thead>
        <th>DEPARTMENT_ID</th>
        <th>DEPARTMENT_NAME</th>
        <th>MANAGER_ID</th>
        <th>LOCATION_ID</th>
    </thead>
    <tbody>
        <tr>
            <td>${vo2.department_id}</td>
            <td>${vo2.department_name}</td>
            <td>${vo2.manager_id}</td>
            <td>${vo2.location_id}</td>
        </tr>
    </tbody>
</table>

<a href="d_update.do?department_id=${vo2.department_id}">수정하기</a>
<a href="d_delete.do?department_id=${vo2.department_id}">삭제하기</a>

</body>
</html>
