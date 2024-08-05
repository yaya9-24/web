<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "로그인 화면" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="loginOK.do" method="post">
  <table border="1">
    <tr>
      <td><label for="id">ID</label></td>
      <td><input type="text" name="id" id="id" value="admin"></td>
    </tr>
    <tr>
      <td><label for="pw">PW</label></td>
      <td><input type="password" name="pw" id="pw" value="hi1234"></td>
    </tr>
    <tr>
      <td><input type="submit" value="로그인"></td>
    </tr>
  </table>
</form>
</body>
</html>