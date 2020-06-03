<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>로그인결과폼</H1>
	<hr>
	<c:if test="${empty	sessionScope.member}">
		<h3>로그인 실패</h3>
	</c:if>
	<c:if test="${not empty	sessionScope.member}">
		<h3>로그인 성공</h3>
	</c:if>
	<br>
	<a href="/goToMain.do">메인으로</a>
</body>
</html>