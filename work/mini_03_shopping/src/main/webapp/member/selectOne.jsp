<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            console.log("ready...")

            let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/json_m_selectOne.do";
            $.ajax({
                url : url2,
                type : "get",
                data : {num :${param.num}},
                dataType : "json",
                success : function (response){
                    console.log(response);
                    let tag = `<tr>
                                    <td>\${response.num}</td>
                                    <td>\${response.id}</td>
                                    <td>\${response.pw}</td>
                                    <td>\${response.name}</td>
                                    <td>\${response.tel}</td>
                               </tr>`;

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
<jsp:include page="../top_menu.jsp"/>
<h1>회원 정보 페이지</h1>
<div>
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
    </table>
</div>
<a href="m_update.do?num=${param.num}">회원정보 수정</a>
</body>
</html>
