<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "전체 직업 목록" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="j_searchList.do">
    <select name="searchKey">
        <option value="job_id">job_id</option>
        <option value="job_title">job_title</option>
    </select>
    <input type="text" name="searchWord" value="AD_PRES">
    <input type="submit" value="검색">
</form>
<table border="1">
    <thead>
        <th>JOB_ID</th>
        <th>JOB_TITLE</th>
        <th>MIN_SALARY</th>
        <th>MAX_SALARY</th>
    </thead>
    <tbody>
        <c:forEach var="vo" items="${list}">
            <tr>
                <td><a href="j_selectOne.do?job_id=${vo.job_id}">${vo.job_id}</a></td>
                <td><a href="j_selectOne.do?job_id=${vo.job_id}">${vo.job_title}</a></td>
                <td>${vo.min_salary}</td>
                <td>${vo.max_salary}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
