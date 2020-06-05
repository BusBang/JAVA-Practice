<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>A_CLASS</h1>
	<form action="/login.do" method="post">
	아이디<br>
	<input type="text" name="memberId"><br>
	비밀번호<br>
	<input type="password" name="memberPw"><br>
	<input type="submit" value="로그인">
	</form>
	<a href="/joinFrm.do">회원가입</a>
	<a href="/searchMember.do">아이디/비밀번호 찾기</a>
</body>
</html>