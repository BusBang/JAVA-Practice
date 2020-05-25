<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script>
	
	</script>
<body>
	<h1>회원가입 페이지</h1>
	아이디 : <input type="text" name="memberId"><br>
	비밀번호 : <input type="password" name="memberPw"><br>
	이름 : <input type="text" name="memberName"><br>
	소속회사 : 
	<select name="companyNo">
		<option value="1">KH</option>
		<option value="2">AMAZON</option>
		<option value="3">APPLE</option>
		<option value="4">SAMSUNG</option>
	</select>
	<br>
	전화번호 : <input type="text" name="phone"><br>
</body>
</html>