<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>전체 회원가입 목록</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>

    $(function (){
      console.log("ready...")

      let url2 = "http://localhost:8090/web07total2_war_exploded/json_m_selectAll.do";
      $.ajax({
        url : url2,
        type : "get",
        dataType : "json",
        success : function (response){
          console.log(response);
          let tag ='';

          for (let i = 0; i < response.length; i++) {
            tag += `<tr>
                      <td><a href="ajax_m_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                      <td>\${response[i].id}</td>
                      <td>\${response[i].pw}</td>
                      <td>\${response[i].name}</td>
                      <td>\${response[i].tel}</td>
                    </tr>`;
          }
          $("#result").html(tag);
        },
        error : function (ex){
          console.log(ex);
        }
      });
    });




  </script>
</head>
<body>
<h1><%= "회원목록 페이지" %></h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<%--검색어 검색은 post로 넘기는 일이 별로 없다.--%>
<form action="m_searchList.do">
  <select name="searchKey">
    <option value="name">name</option>
    <option value="id">id</option>
  </select>
  <input type="text" name="searchWord" value="홍길동" placeholder="검색어를 입력하세요">
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
  <tbody id="result">

  </tbody>
  <tfoot>
  <tr>
    <td colspan="5">1 2 3 4</td>
  </tr>
  </tfoot>
</table>
</body>
</html>