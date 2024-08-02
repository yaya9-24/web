<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<hr>

<form action="c_insertOK.do" method="post">
    <table border="1">
        <tr>

            <td><input type="hidden" id="bnum" name="bnum" value="${vo2.num}"></td>
        </tr>
        <tr>
            <td>댓글 입력</td>
            <td><textarea id="content" name="content" cols="30" rows="10">comment1</textarea></td>
        </tr>
        <tr>
            <td><label for="writer">작성자:</label> </td>
            <td><input type="text" id="writer" name="writer" value="admin3"></td>
        </tr>
        <tr>
            <td><input type="submit" value="댓글입력"></td>
        </tr>
    </table>
</form>

<hr>

<table border="1">
    <thead>
        <th>번호</th>
        <th>내용</th>
        <th>작성자</th>
        <th>작성일자</th>
    </thead>
    <tbody>
    <c:forEach var="cvo" items="${clist}">
        <tr>
            <td>${cvo.num}</td>
            <td>${cvo.content}</td>
            <td>${cvo.writer}</td>
            <td>${cvo.wdate}</td>
            <td>
                <a href="c_deleteOK.do?num=${cvo.num}&bnum=${vo2.num}">댓글삭제</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
