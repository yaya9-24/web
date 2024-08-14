<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>후기 작성</title>
</head>
<body>
<jsp:include page="../top_menu.jsp"/>
<div>
    <h1>후기 작성 페이지</h1>
    <form action="b_insertOK.do" method="post" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <td><label for="title">제목</label></td>
                <td><input type="text" id="title" name="title" value="GG"></td>
            </tr>
            <tr>
                <td><label for="content">내용</label></td>
                <td><input type="text" id="content" name="content" value="GG"></td>
            </tr>
            <tr>
                <td><label for="writer">작성자</label></td>
                <td>${user_id}<input type="hidden" id="writer" name="writer" value="${user_id}"></td>
            </tr>
            <tr>
                <td><label for="upFile">파일업로드</label></td>
                <td><input type="file" id="upFile" name="upFile"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="작성 완료"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
