<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "DEPT 삭제" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="d_deleteOK.do" method="post">
    <table>
        <tr>
            <td>${param.department_id}를 삭제 하시겠습니까?</td>
            <td><input type="hidden" name="department_id" value="${param.department_id}"></td>
        </tr>

        <tr>
            <td><input type="submit" value="삭제완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
