<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "JOB 삭제" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="j_deleteOK.do" method="post">
    <table>
        <tr>
            <td>${param.job_id}를 삭제 하시겠습니까?</td>
            <td><input type="hidden" name="job_id" value="${param.job_id}"></td>
        </tr>

        <tr>
            <td><input type="submit" value="제출완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
