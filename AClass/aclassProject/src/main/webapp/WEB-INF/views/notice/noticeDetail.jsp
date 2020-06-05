<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<td>${notice.noticeNo}</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td>${notice.noticeTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${notice.noticeWriter}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${notice.noticeContent}</td>
		</tr>
	</table>
	<a href="noticeList.do?reqPage=1">메인으로</a>
</body>
</html>