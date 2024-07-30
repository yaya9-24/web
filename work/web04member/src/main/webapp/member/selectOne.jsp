<%@ page import="com.example.web04member.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원번호검색</title>
</head>
<body>
<h1><%= "회원번호검색" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
  <thead>
  <tr>
    <th>회원번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>전화번호</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <%
      MemberVO vo2 = (MemberVO) request.getAttribute("vo2");
    %>

    <td>${vo2.num}</td>
    <td>${vo2.id}</td>
    <td>${vo2.pw}</td>
    <td>${vo2.name}</td>
    <td>${vo2.tel}</td>
  </tr>
  </tbody>
</table>
<a href="m_update.do?id=${vo2.id}">회원정보 수정</a>
<a href="m_delete.do?id=${vo2.id}">회원정보 삭제</a>
</body>
</html>