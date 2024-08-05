<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "JOB 추가" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>

<form action="j_insertOK.do" method="post">
    <table>
        <tr>
            <td><label for="job_id">JOB_ID</label></td>
            <td><input type="text" id="job_id" name="job_id"></td>
        </tr>
        <tr>
            <td><label for="job_title">JOB_TITLE</label></td>
            <td><input type="text" id="job_title" name="job_title"></td>
        </tr>
        <tr>
            <td><label for="min_sal">MIN_SALARY</label></td>
            <td><input type="text" id="min_sal" name="min_sal"></td>
        </tr>
        <tr>
            <td><label for="max_sal">MAX_SALARY</label></td>
            <td><input type="text" id="max_sal" name="max_sal"></td>
        </tr>
        <tr>
            <td><input type="submit" value="제출완료"></td>
        </tr>
    </table>
</form>
</body>
</html>
