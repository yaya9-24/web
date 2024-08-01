<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "회원정보 삭제" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="m_deleteOK.do" method="post">
  <table border="1">
    <tbody>
    <tr>
      <td>${param.num} 번 회원을 정말 삭제하시겠습니까?</td>
      <td><input type="hidden" name="num" value="${param.num}"></td>
    </tr>
    </tbody>
    <tfoot>
      <td><input type="submit" value="회원탈퇴"></td>
    </tfoot>
  </table>
</form>
</body>
</html>