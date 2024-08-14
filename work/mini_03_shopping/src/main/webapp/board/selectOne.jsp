<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            console.log("ready...")

            let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/json_b_selectOne.do";
            $.ajax({
                url : url2,
                type : "get",
                data : {num :${param.num}},
                dataType : "json",
                success : function (response){
                    console.log(response);
                    let tag = `<tr>
                                    <td>\${response.num}</td>
                                    <td>\${response.title}</td>
                                    <td>\${response.content}</td>
                                    <td>\${response.writer}</td>
                                    <td>\${response.wdate}</td>
                                    <td>\${response.imgName}</td>
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
<h1>후기 목록</h1>
<div>
    <table border="1">
        <thead>
        <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성날짜</th>
            <th>이미지</th>
        </tr>
        </thead>
        <tbody id="result">

        </tbody>
    </table>
</div>
<a href="b_update.do?num=${param.num}">게시글 수정</a>
</body>
</html>
