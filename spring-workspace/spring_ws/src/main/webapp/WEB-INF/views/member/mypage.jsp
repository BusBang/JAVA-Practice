<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<body>
	<h1>${m.memberName }님의 마이페이지</h1>
	<form action="/mUpdate.do" method="post">
		아이디 : <input type="text" name="memberId" value="${m.memberId }" readonly><br>
		비밀번호 : <input type="text" name="memberPw" value="${m.memberPw }"><br>
		이름 : <input type="text" name="memberName" value="${m.memberName }"><br>
		나이 : <input type="text" name="age" value="${m.age }"><br>
		가입일 : <input type="text" name="enrollDate" value="${m.enrollDate }" readonly><br>
		<input type="submit" value="정보수정"><br>
	</form>
	<a href="/mDelete.do">회원탈퇴하기</a>
</body>
</html>