<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "test2.jsp" %>
</h1>
<br/>
    <jsp:include page="../top_menu.jsp"/> <%--..은 상위를 의미한다. 이런 것을 상대 경로라고 한다.--%>
</body>
</html>