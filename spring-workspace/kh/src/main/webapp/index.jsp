<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/kh/member/login.kh" method="post">
		<fieldset>
			<legend>로그인</legend>
			아이디 : <input type="text" name="id"><br>
			비번 : <input type="password" name="pw"><br>
			<input type="submit" value="로그인">
		</fieldset>
	</form>
</body>
</html>