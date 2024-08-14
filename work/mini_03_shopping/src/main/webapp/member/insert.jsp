<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
    <style>
        body {
            font-family: 'Helvetica Neue', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #e0e0e0;
            color: #333;
        }

        /* 메뉴바 스타일 */
        .menu-container {
            width: 100%;
            background-color: #ffffff;
            padding: 10px 0;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        /* 컨텐츠 스타일 */
        .content-container {
            margin-top: 70px; /* 메뉴바 높이 + 추가 여백 */
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: calc(100vh - 70px);
        }

        .form-container {
            background-color: #ffffff;
            padding: 25px;
            border-radius: 6px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 350px;
            width: 100%;
        }

        h1 {
            color: #444;
            text-align: center;
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="button"],
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            width: 100%;
            margin-top: 10px;
        }

        input[type="button"]:hover,
        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        #result {
            margin-left: 10px;
            font-size: 12px;
            color: #666;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            $("#btn_idCheck").click(function (){
                console.log("click...");

                let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/m_idCheck.do";
                $.ajax({
                    url : url2,
                    type : "get",
                    data : {id:$("#id").val()},
                    dataType : "json",
                    success : function (response){
                        console.log(response);
                        let message = '';
                        if (response.result ==='OK'){
                            message = '사용가능';
                        } else {
                            message = '중복된 아이디';
                        }
                        $("#result").html(message);
                    },
                    error : function (ex){
                        console.log(ex);
                    }
                })
            })
        });
    </script>
</head>
<body>
<div class="menu-container">
    <jsp:include page="../top_menu.jsp"/>
</div>

<div class="content-container">
    <div class="form-container">
        <h1>회원가입</h1>
        <form action="m_insertOK.do" method="post">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" value="admin">
            <input type="button" id="btn_idCheck" value="중복체크">
            <span id="result"></span>

            <label for="pw">PW</label>
            <input type="text" id="pw" name="pw" value="hi1111">

            <label for="name">NAME</label>
            <input type="text" id="name" name="name" value="kim" placeholder="NAME를 입력하세요">

            <label for="tel">TEL</label>
            <input type="text" id="tel" name="tel" value="010" placeholder="TEL를 입력하세요">

            <input type="submit" value="가입완료">
        </form>
    </div>
</div>
</body>
</html>