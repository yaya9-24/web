<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>글번호검색</title>
    <script>
        $(function (){
            console.log("ready");
            let url2 = "http://localhost:8090/web07total2_war_exploded/json_b_selectOne.do";
            $.ajax({
                url : url2,
                type : "get",
                data : {num:${param.num}},
                dataType : "json",
                success : function (response){
                    console.log(response);
                    let tag = `<tr>
                                <td>\${response.num}</td>
                                <td>\${response.title}</td>
                                <td>\${response.content}</td>
                                <td>\${response.writer}</td>
                                <td>\${response.wdate}</td>
                                </tr>`;

                    $("#result").html(tag);
                },
                error : function (ex){
                    console.log(ex)
                }
            });
        });
    </script>
</head>
<body>
<h1><%= "글번호검색" %></h1>
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
    <tbody id="result">

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
            <td>${user_id}<input type="hidden" id="writer" name="writer" value="${user_id}"></td>
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
                <c:if test="${user_id==cvo.writer}">
                <a href="c_deleteOK.do?num=${cvo.num}&bnum=${vo2.num}">댓글삭제</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
