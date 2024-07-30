<%@ page import="com.example.web03board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>글번호검색</title>
</head>
<body>
<h1><%= "글번호검색" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
    <thead>
    <tr>
        <th>글번호</th>
        <th>글제목</th>
        <th>글내용</th>
        <th>작성자</th>
        <th>작성일자</th>
    </tr>
    </thead>
    <tbody>

    <tr>
<%--        <td><%= request.getParameter("num")%></td>--%>
<%--        <td><%= request.getAttribute("num")%></td> expression tag라 한다.--%>
<%--        <td>${param.num+4*4/4%4}</td> expression language라 한다. el이라고도 불리며 이것을 더 많이 사용한다.--%>
        <%
            BoardVO vo2 = (BoardVO)request.getAttribute("vo2");
        %>
        <td><%=vo2.getNum()%></td>
        <td><%=vo2.getTitle()%></td>
        <td><%=vo2.getContent()%></td>
        <td><%=vo2.getWriter()%></td>
        <td><%=vo2.getWdate()%></td>
    </tr>
    <tr>
        <%--        <td><%= request.getParameter("num")%></td>--%>
        <%--        <td><%= request.getAttribute("num")%></td> expression tag라 한다.--%>
        <%--        <td>${param.num+4*4/4%4}</td> expression language라 한다. el이라고도 불리며 이것을 더 많이 사용한다.--%>
        <td>${vo2.num}</td>
        <td>${vo2.title}</td>
        <td>${vo2.content}</td>
        <td>${vo2.writer}</td>
        <td>${vo2.wdate}</td>
    </tr>
    </tbody>
</table>
<a href="b_update.do?num=${vo2.num}">게시글수정</a>
<a href="b_delete.do?num=${vo2.num}">게시글삭제</a>
</body>
</html>
