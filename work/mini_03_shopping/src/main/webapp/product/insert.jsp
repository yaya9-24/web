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
    <h1>상품 등록 페이지</h1>
    <form action="p_insertOK.do" method="post" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <td><label for="pname">상품명</label></td>
                <td><input type="text" id="pname" name="pname" value="BOOK1"></td>
            </tr>
            <tr>
                <td><label for="price">가격</label></td>
                <td><input type="text" id="price" name="price" value="5000"></td>
            </tr>
            <tr>
                <td><label for="upFile">이미지업로드</label></td>
                <td><input type="file" id="upFile" name="upFile"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="등록 완료"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
