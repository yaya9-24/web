<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "로그인 화면" %>
</h1>
<br/>
<a href="home.do">HOME</a>
<a href="login.do">login</a>
<hr>
<form action="loginOK.do" method="post">
    <table border="1">
        <tr>
            <td><label for="id">ID</label></td>
            <td><input type="text" id="id" name="id" value="admin"></td>
        </tr>
        <tr>
            <td><label for="pw">PW</label></td>
            <td><input type="password" id="pw" name="pw" value="hi1111"></td>
        </tr>
        <tr>
            <td colspan="4"><input type="submit" value="로그인"></td>
        </tr>
    </table>
</form>
</body>
</html>