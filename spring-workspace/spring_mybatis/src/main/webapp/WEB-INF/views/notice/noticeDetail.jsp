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
	<h2>게시글 상세보기</h2>
	<hr>
	<table>
		<tr>
			<th>제목</th>
			<td>${n.noticeTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${n.noticeWriter}</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<c:if test="${not empty n.filepath}">
					<img src="/resources/upload/notice/${n.filepath}">				
				</c:if>
				<c:if test="${empty n.filepath}">
					<img src="/resources/upload/notice/댕댕이.jpg">				
				</c:if>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${n.noticeContent}</td>
		</tr>
		<tr>
			<th colspan="2">
				<a href="/noticeUpdateFrm.do?noticeNo=${n.noticeNo }">수정</a>
				<a href="/noticeDelete.do?noticeNo=${n.noticeNo }">삭제</a>
			</th>
		</tr>
	</table>	
</body>
</html>