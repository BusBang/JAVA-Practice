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
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>게시글 제목</th>
			<th>게시글 작성자</th>
			<th>게시글 등록일</th>
		</tr>
		<c:forEach items="${list }" var="n">
			<tr>
				<td>${n.noticeNo }</td>
				<td><a href="/noticeDetail.do?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td>
				<td>${n.noticeWriter }</td>
				<td>${n.regDate }</td>	
			</tr>
		</c:forEach>		
	</table>
	<div>
		${pageNavi }
	</div>
	<hr>
	<a href="/noticeWriteFrm.do">글쓰러가기</a>
</body>
</html>