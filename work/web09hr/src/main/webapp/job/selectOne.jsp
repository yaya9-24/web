<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "선택 직업" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<table border="1">
    <thead>
        <th>JOB_ID</th>
        <th>JOB_TITLE</th>
        <th>MIN_SALARY</th>
        <th>MAX_SALARY</th>
    </thead>
    <tbody>
        <tr>
            <td>${vo2.job_id}</td>
            <td>${vo2.job_title}</td>
            <td>${vo2.min_salary}</td>
            <td>${vo2.max_salary}</td>
        </tr>
    </tbody>
</table>

<a href="j_update.do?job_id=${vo2.job_id}">수정하기</a>
<a href="j_delete.do?job_id=${vo2.job_id}">삭제하기</a>

</body>
</html>
