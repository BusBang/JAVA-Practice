<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>게시글 페이지</H1>
	<hr>
	<table border=1>
		<tr>
			<th>게시글 번호</th>
			<th>게시글 제목</th>
			<th>게시글 작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
		</tr>
		<c:forEach items="${list }" var="n">
			<tr>
				<td>${n.noticeNo }</td>
				<td><a href="/noticeDetail.do?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td>
				<td>${n.noticeWriter }</td>
				<td>${n.regDate }</td>	
				<td>
					<c:if test="${empty n.filepath}">
						O
					</c:if>
					<c:if test="${not empty n.filepath}">
						X
					</c:if>
				</td>	
			</tr>
		</c:forEach>
	</table>
	<div>${pageNavi }</div>
	<a href="/">메인페이지로.</a>		
</body>
</html>