<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/noticeList.do?reqPage=1">게시판 목록 이동</a>
	<hr>
	
<!-- 	<img> -->
	<br>
	<table>
		<tr>
			<th>소속</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>등급</th>
		</tr>
		<tr>
			<th><img src="/resources/update/department/${sessionScope.member.deptNo }.png" style='width:150px; height:50px;'></th>
			<th>${sessionScope.member.memberId}</th>
			<th>${sessionScope.member.memberName}</th>
			<th>${sessionScope.member.phone}</th>
			<th>${sessionScope.member.grade}</th>
		</tr>
	</table>
	<a href="/logout.do">로그아웃</a>

</body>
</html>