<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
		<form action="updateMember.do" method="post">
		NO : <input type="text" name="memberNo" value="${sessionScope.member.memberNo }" readonly><br>
		ID : <input type="text" name="memberId" value="${sessionScope.member.memberId }" readonly><br>
		PW : <input type="password" name="memberPw" value="${sessionScope.member.memberPw }" readonly><br>
		NAME : <input type="text" name="memberName" value="${sessionScope.member.memberName }"><br>
		AGE : <input type="text" name="age" value="${sessionScope.member.age }"><br>
		ENROLL_DATE : <input type="text" name="enrollDate" value="${sessionScope.member.enrollDate }"><br>
	<input type="submit" value="Modify">
	</form>
	<hr>
	
</body>
</html>