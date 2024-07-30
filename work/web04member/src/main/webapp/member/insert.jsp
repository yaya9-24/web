<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <h1><%= "회원가입 작성 페이지" %></h1>
  <form action="m_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="id">아이디</label></td>
        <td><input type="text" id="id" name="id" placeholder="아이디를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="pw">비밀번호</label></td>
        <td><input type="text" id="pw" name="pw" placeholder="비밀번호를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="name">이름</label></td>
        <td><input type="text" id="name" name="name" placeholder="이름을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="tel">전화번호</label></td>
        <td><input type="text" id="tel" name="tel" placeholder="전화번호를 입력하세요"></td>
      </tr>
      <tr>
        <td colspan="4"><input type="submit" value="회원가입"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>