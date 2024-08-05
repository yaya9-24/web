<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "EMP 추가" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="e_insertOK.do" method="post">
    <table border="1">
        <tr>
            <td><label for="first_name">FIRST_NAME</label></td>
            <td><input type="text" id="first_name" name="first_name"></td>
        </tr>
        <tr>
            <td><label for="last_name">LAST_NAME</label></td>
            <td><input type="text" id="last_name" name="last_name"></td>
        </tr>
        <tr>
            <td><label for="email">EMAIL</label></td>
            <td><input type="text" id="email" name="email"></td>
        </tr>
        <tr>
            <td><label for="phone_number">PHONE_NUMBER</label></td>
            <td><input type="text" id="phone_number" name="phone_number"></td>
        </tr>
        <tr>
            <td><label for="hire_date">HIRE_DATE</label></td>
            <td><input type="date" id="hire_date" name="hire_date"></td>
        </tr>
        <tr>
            <td><label for="job_id">JOB_ID</label></td>
            <td><input type="text" id="job_id" name="job_id"></td>
        </tr>
        <tr>
            <td><label for="salary">SALARY</label></td>
            <td><input type="text" id="salary" name="salary"></td>
        </tr>
        <tr>
            <td><label for="commission_pct">COMMISSION_PCT</label></td>
            <td><input type="text" id="commission_pct" name="commission_pct"></td>
        </tr>
        <tr>
            <td><label for="manager_id">MANAGER_ID</label></td>
            <td><input type="text" id="manager_id" name="manager_id"></td>
        </tr>
        <tr>
            <td><label for="department_id">DEPARTMENT_ID</label></td>
            <td><input type="text" id="department_id" name="department_id"></td>
        </tr>
        <tr>
            <td><input type="submit" value="제출완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
