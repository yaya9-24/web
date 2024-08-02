
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>전체글목록</title>
</head>
<body>
<h1><%= "게시글 목록 페이지" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<%--검색어 검색은 post로 넘기는 일이 별로 없다.--%>
<form action="b_searchList.do">
    <select name="searchKey">
        <option value="title">title</option>
        <option value="content">content</option>
    </select>
    <input type="text" name="search_word" value="java" placeholder="검색어를 입력하세요">
    <input type="submit" value="검색">
</form>
<table border="1">
    <thead>
        <tr>
            <th>글번호</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>작성일자</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="vo" items="${list}">
        <tr>
            <td><a href="b_selectOne.do?num=${vo.num}">${vo.num}</a></td>
            <td><a href="b_selectOne.do?num=${vo.num}">${vo.title}</a></td>
            <td>${vo.writer}</td>
            <td>${vo.wdate}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
        <tr>
            <td colspan="4">1 2 3 4</td>
        </tr>
    </tfoot>
</table>

</body>
</html>
