<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보  수정</title>
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
        p {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        #deleteOK  {
            background-color: #ff0047;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            width: 100%;
            margin-top: 10px;
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
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            $("#deleteOK").click(function (){
                console.log("click...");
                event.preventDefault();
                let result = confirm("정말 삭제하시겠습니까?")
                if (result){
                    $(this).closest("form").submit();
                } else {
                    location.reload();
                }
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
        <h1>게시글 수정</h1>
        <form action="b_updateOK.do" method="post" enctype="multipart/form-data">

            <input type="hidden" id="num" name="num" value="${param.num}">

            <label for="title">TITLE</label>
            <input type="text" id="title" name="title" value="${vo2.title}">

            <label for="content">CONTENT</label>
            <input type="text" id="content" name="content" value="${vo2.content}">

            <label for="writer">WRITER</label>
            <p>${vo2.writer}</p><input type="hidden" id="writer" name="writer" value="${vo2.writer}">

            <label for="wdate">WDATE</label>
            <input type="text" id="wdate" name="wdate" value="${vo2.wdate}">

            <label for="img">IMG</label>
            <input type="file" id="img" name="img" value="${vo2.imgName}">
            <input type="submit" value="수정하기">
        </form>
        <form action="b_deleteOK.do" method="post">
            <input type="hidden" id="num2" name="num2" value="${param.num}">
            <input type="submit" value="삭제하기" id="deleteOK" name="deleteOK">
        </form>
    </div>
</div>
</body>
</html>