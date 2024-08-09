<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        input[type=text],
        textarea,
        select {
            width: 100%;
            padding: 8px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ff8f8f;
            border-radius: 14px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 30%;
            background-color: #4CAF50;
            color: white;
            padding: 8px 8px;
            margin: 8px 0;
            border: none;
            border-radius: 14px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #b7e5b9;
        }

        div {
            border-radius: 15px;
            background-color: #f0f0f0;
            padding: 20px;
        }

        #insertTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #insertTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #insertTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #insertTable tr:hover {
            background-color: #ffc6c6;
        }
    </style>
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
    <h1><%= "상품 구매 페이지"%></h1>
    <form action="p_insertOK.do" method="post">
        <table id="insertTable">
            <tr>
                <td><label for="pname">상품이름</label></td>
                <td><input type="text" id="pname" name="pname" value="BMW" placeholder="상품이름을 입력하세요"></td>
            </tr>
            <tr>
                <td><label for="model">모델이름</label></td>
                <td><input type="text" name="model" id="model" value="M5" placeholder="모델명을 입력하세요."></td>
            </tr>
            <tr>
                <td><label for="price">가격</label></td>
                <td><input type="text" id="price" name="price" value="9999"></td>
            </tr>
            <tr>
                <td><label for="count">개수</label></td>
                <td><input type="text" id="count" name="count" value="2"></td>
            </tr>
            <tr>
                <td><label for="user_id">구매자</label></td>
                <td><input type="text" id="user_id" name="user_id" value="키미히"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="구매 완료"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
