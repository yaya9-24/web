<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "전체 부서 목록" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="d_searchList.do">
    <select name="searchKey">
        <option value="department_id">department_id</option>
        <option value="department_name">department_name</option>
    </select>
    <input type="text" name="searchWord" value="AD_PRES">
    <input type="submit" value="검색">
</form>
<table border="1">
    <thead>
        <th>DEPARTMENT_ID</th>
        <th>DEPARTMENT_NAME</th>
        <th>MANAGER_ID</th>
        <th>LOCATION_ID</th>
    </thead>
    <tbody>
        <c:forEach var="vo" items="${list}">
            <tr>
                <td><a href="d_selectOne.do?department_id=${vo.department_id}">${vo.department_id}</a></td>
                <td><a href="d_selectOne.do?department_id=${vo.department_id}">${vo.department_name}</a></td>
                <td>${vo.manager_id}</td>
                <td>${vo.location_id}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
