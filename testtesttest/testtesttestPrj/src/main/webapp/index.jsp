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
	<h1>메인페이지</h1>
	<hr>
	<c:if test="${empty sessionScope.member}">
		<form action="/login.do" method="post">
			ID : <input type="text" name="memberId"><br>
			PW : <input type="text" name="memberPw"><br>
			<input type="submit" value="Login"> 
		</form>
		<a href="/joinFrm.do">회원가입</a>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
		<a href="/myPage.do">마이페이지가기</a>
		<a href="/logout.do">로그아웃</a>
		<a href="/boardList.do?reqPage=1">게시판목록</a>
	</c:if>
</body>
</html>