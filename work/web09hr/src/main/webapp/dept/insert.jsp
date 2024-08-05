<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "DEPT 추가" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="d_insertOK.do" method="post">
    <table>
<%--        <tr>--%>
<%--            <td><label for="department_id">DEPARTMENT_ID</label></td>--%>
<%--            <td><input type="hidden" id="department_id" name="department_id"></td>--%>
<%--        </tr>--%>
        <tr>
            <td><label for="department_name">DEPARTMENT_NAME</label></td>
            <td><input type="text" id="department_name" name="department_name"></td>
        </tr>
        <tr>
            <td><label for="manager_id">MANAGER_ID</label></td>
            <td><input type="number" id="manager_id" name="manager_id"></td>
        </tr>
        <tr>
            <td><label for="location_id">LOCATION_ID</label></td>
            <td><input type="number" id="location_id" name="location_id"></td>
        </tr>
        <tr>
            <td><input type="submit" value="제출완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
