<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "DEPT 수정" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="d_updateOK.do" method="post">
    <table border="1">
        <tr>
            <td><label for="department_id">DEPARTMENT_ID</label></td>
            <td><input type="number" id="department_id" name="department_id" value="${vo2.department_id}"></td>
        </tr>
        <tr>
            <td><label for="department_name">DEPARTMENT_NAME</label></td>
            <td><input type="text" id="department_name" name="department_name" value="${vo2.department_name}"></td>
        </tr>
        <tr>
            <td><label for="manager_id">MANAGER_ID</label></td>
            <td><input type="number" id="manager_id" name="manager_id" value="${vo2.manager_id}"></td>
        </tr>
        <tr>
            <td><label for="location_id">LOCATION_ID</label></td>
            <td><input type="number" id="location_id" name="location_id" value="${vo2.location_id}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="수정완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
