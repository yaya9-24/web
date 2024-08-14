<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            console.log("ready...")

            let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/json_b_selectAll.do";
            $.ajax({
                url : url2,
                type : "get",
                dataType : "json",
                success : function (response){
                    console.log(response);
                    let tag = '';
                    for (let i = 0; i < response.length; i++) {
                        tag +=`<tr>
                                    <td><a href="b_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                                    <td>\${response[i].title}</td>
                                    <td>\${response[i].content}</td>
                                    <td>\${response[i].writer}</td>
                                    <td>\${response[i].wdate}</td>
                                    <td>\${response[i].imgName}</td>
                               </tr>`;
                    }
                    $("#result").html(tag);
                },
                error : function (ex){
                    console.log(ex);
                }
            });
            $("#submit").click(function (){
                let url3 = "http://localhost:8090/mini_03_shopping_war_exploded/json_b_searchList.do";
                $.ajax({
                    url : url3,
                    type : "get",

                    dataType : "json",
                    success : function (response){
                        console.log(response);
                        let tag = `<tr>
                                    <td><a href="b_selectOne.do?num=\${response.num}">\${response.num}</a></td>
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

        });
    </script>
</head>
<body>
<jsp:include page="../top_menu.jsp"/>
<h1>상품 후기 페이지</h1>
<form action="json_b_searchList.do">
    <select name="searchKey">
        <option value="name">name</option>
        <option value="id">id</option>
    </select>
    <input type="text" name="searchWord" value="admin">
    <input type="submit" value="검색" id="submit">
</form>

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
        <tfoot>
        <tr>
            <td colspan="6" align="center">1 2 3 4</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
