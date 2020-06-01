<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="noticeUpdate.do" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${n.noticeNo }">
		제목 : <input type="text" value="${n.noticeTitle }" name="noticeTitle"><br>
		작성자 : <input type="text" value="${n.noticeWriter }" name="noticeWriter"><br>
		첨부파일 : <input type="file" name="file"><br>
		내용 : <textarea rows="5" cols="20" name="noticeContent">${n.noticeContent }</textarea>
		<input type="submit" value="등록">
	</form>
</body>
</html>