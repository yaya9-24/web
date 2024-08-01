<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원번호검색</title>
</head>
<body>
<h1><%= "회원 정보 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
  <thead>
  <tr>
    <th>NUM</th>
    <th>ID</th>
    <th>PW</th>
    <th>NAME</th>
    <th>TEL</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${vo2.num}</td>
    <td>${vo2.id}</td>
    <td>${vo2.pw}</td>
    <td>${vo2.name}</td>
    <td>${vo2.tel}</td>
  </tr>
  </tbody>
</table>
<a href="m_update.do?num=${vo2.num}">회원정보 수정</a>
<a href="m_delete.do?num=${vo2.num}">회원정보 삭제</a>
</body>
</html>