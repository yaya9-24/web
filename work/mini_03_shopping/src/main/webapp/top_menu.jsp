<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr>
<a href="home.do">HOME</a>
<a href="b_selectAll.do">후기 목록</a>
<a href="b_insert.do">후기 작성</a>
<%--<a href="p_insertList.do">상품 구매</a>--%>
<a href="p_selectAll.do">상품 목록</a>
<a href="p_insert.do">상품 등록</a>
<a href="m_selectAll.do">회원 목록</a>
<a href="m_insert.do">회원 가입</a>
<c:if test="${user_id==null}"><a href="login.do">로그인</a></c:if>
<c:if test="${user_id!=null}"><a href="logout.do">로그아웃</a></c:if>

<hr>