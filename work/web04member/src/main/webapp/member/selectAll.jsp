<%@ page import="java.util.List" %>
<%@ page import="com.example.web04member.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>전체 회원가입 목록</title>
</head>
<body>
<h1><%= "전체 회원가입 목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<%--검색어 검색은 post로 넘기는 일이 별로 없다.--%>
<form action="m_searchList.do">
  <select name="searchKey">
    <option value="name">name</option>
    <option value="id">id</option>
  </select>
  <input type="text" name="search_word" value="홍길동" placeholder="검색어를 입력하세요">
  <input type="submit" value="검색">
</form>
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
  <%
    List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
    for (MemberVO x : list){
  %>
  <tr>
    <td><a href="m_selectOne.do?num=<%= x.getNum()%>"><%= x.getNum()%></a></td>
    <td><a href="m_selectOne.do?num=<%= x.getId()%>"><%= x.getId()%></a></td>
    <td><%= x.getPw()%></td>
    <td><%= x.getName()%></td>
    <td><%= x.getTel()%></td>
  </tr>
  <%
    }
  %>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="4">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>