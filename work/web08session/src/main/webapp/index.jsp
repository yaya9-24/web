<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "HOME" %>
</h1>
<br/>
<a href="home.do">HOME</a>
<c:if test="${user_id==null}"><a href="login.do">login</a></c:if>
<c:if test="${user_id!=null}"><a href="logout.do">logout</a></c:if>

<h1>세션정보</h1>
<h1>${user_id}</h1>
<h1>${name}</h1>
<hr>
<h1>쿠키정보</h1>
<h1>${cookie['message'].value}</h1>
<h1>${cookie['isChecked'].value}</h1>
</body>
</html>