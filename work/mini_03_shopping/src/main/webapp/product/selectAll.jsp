<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            console.log("ready...")

            let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/json_p_selectAll.do";
            $.ajax({
                url : url2,
                type : "get",
                dataType : "json",
                success : function (response){
                    console.log(response);
                    let tag = '';
                    for (let i = 0; i < response.length; i++) {
                        tag +=`<tr>
                                    <td><a href="p_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                                    <td>\${response[i].pname}</td>
                                    <td>\${response[i].price}원</td>
                                    <td>\${response[i].imgName}</td>
                                    <td><img src="upload/\${response[i].imgName}" height="300px"></td>
                               </tr>`;
                    }
                    $("#result").html(tag);
                },
                error : function (ex){
                    console.log(ex);
                }
            });
            $("#form_searchList").submit(function (){
                let url3 = "http://localhost:8090/mini_03_shopping_war_exploded/json_m_searchList.do";
                $.ajax({
                    url : url3,
                    type : "get",

                    dataType : "json",
                    success : function (response){
                        console.log(response);
                        let tag = `<tr>
                                    <td><a href="m_selectOne.do?num=\${response.num}">\${response.num}</a></td>
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
            return false;
        });
    </script>
</head>
<body>
<jsp:include page="../top_menu.jsp"/>
<h1>상품 목록 페이지</h1>
<form action="" id="form_searchList">
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
            <th>상품번호</th>
            <th>상품명</th>
            <th>가격</th>
            <th>이미지파일</th>
            <th>이미지원본</th>
        </tr>
        </thead>
        <tbody id="result">

        </tbody>
        <tfoot>
        <tr>
            <td colspan="5" align="center">1 2 3 4</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>
