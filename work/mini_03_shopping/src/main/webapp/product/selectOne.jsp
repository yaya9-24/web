<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 상세 페이지</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function (){
            let url2 = "http://localhost:8090/mini_03_shopping_war_exploded/json_p_selectOne.do?";

            $.ajax({
                url : url2,
                type : "get",
                data : {num :${param.num}},
                dataType : "json",
                success : function (response){
                    console.log(response);

                    // 상품 정보 표시
                    $("#productImage").attr("src","upload/"+response.imgName);
                    $("#productName").text(response.pname);
                    $("#productPrice").text(response.price + "원");

                    // 초기 개수와 총 가격 설정
                    let count = 1;
                    $("#count").val(count);
                    $("#totalPrice").text(response.price * count + "원");

                    // 개수가 변경될 때마다 총 가격 업데이트
                    $("#count").click(function() {
                        count = $(this).val();
                        let totalPrice = response.price * count;
                        $("#totalPrice").text(totalPrice + "원");
                    });

                    // 구매하기 버튼 클릭 시 처리
                    $("#buyButton").click(function(){
                        alert("구매가 완료되었습니다.");
                        // 추가적인 로직은 여기에 구현
                        location.href ='';
                    });

                    // 장바구니 버튼 클릭 시 처리
                    $("#cartButton").click(function(){
                        alert("장바구니에 추가되었습니다.");
                        // 추가적인 로직은 여기에 구현
                        location.href ='';
                    });
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
<h1>상품 상세 페이지</h1>

<div style="display: flex;">
    <!-- 왼쪽에 이미지 표시 -->
    <div style="flex: 5;">
        <img id="productImage" src="" alt="상품 이미지" width="400px" height="400px">
    </div>

    <!-- 오른쪽에 상품 정보 표시 -->
    <div style="flex: 5; padding-left: 100px;">
        <h1 id="productName"></h1>
        <p>가격: <span id="productPrice"></span></p>
        <p>개수: <input type="number" id="count" value="1" min="1" max="100"></p>
        <p>총 가격: <span id="totalPrice"></span></p>
        <input type="button" id="buyButton" value="구매하기">
        <input type="button" id="cartButton" value="장바구니">
    </div>
</div>
</body>
</html>
