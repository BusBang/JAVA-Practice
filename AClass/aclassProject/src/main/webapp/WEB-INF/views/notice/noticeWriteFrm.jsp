<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="noticeWrite.do" method="post">
	<table>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="noticeTitle"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="noticeWriter" value="${sessionScope.member.memberId }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="5" cols="30" name="noticeContent"></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" value="작성완료">
	</form>
	<a href="noticeList.do?reqPage=1">메인으로</a>
</body>
</html>