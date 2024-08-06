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
  <script>
  window.onload = function (){
    document.getElementById("btn_idCheck").onclick = function (){
      console.log("onclick...")

      let id = document.getElementById("id").value;

      const xhttp = new XMLHttpRequest();
      xhttp.onload = function (){
        console.log(this.responseText);

        let obj = JSON.parse(this.responseText);

      };
      xhttp.open("GET","http://localhost:8090/web07total2_war_exploded/m_idCheck.do?id="+id);
      xhttp.send();
    };
  };

  </script>
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1><%= "회원가입" %></h1>
  <form action="m_insertOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="id">ID</label></td>
        <td>
          <input type="text" id="id" name="id" value="admin" placeholder="ID를 입력하세요">
          <button type="button" id="btn_idCheck">중복체크</button>
          버튼추가, 비동기통신 ,db연동해서 결과출력(사용가능 or 중복된 아이디)
        </td>
      </tr>
      <tr>
        <td><label for="pw">PW</label></td>
        <td><input type="text" id="pw" name="pw" value="hi1111" placeholder="PW를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="name">NAME</label></td>
        <td><input type="text" id="name" name="name" value="kim" placeholder="이름을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="tel">TEL</label></td>
        <td><input type="text" id="tel" name="tel" value="010" placeholder="전화번호를 입력하세요"></td>
      </tr>
      <tr>
        <td colspan="4"><input type="submit" value="가입완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>