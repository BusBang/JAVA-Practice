<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
	<script>
		$(function() {
			$("#fileDelBtn").click(function() {
				$(".delFile").hide();
				$("#file").show();
				$("input[name=status]").val('delete');

			});

		})
	</script>
<body>
	<form action="noticeUpdate.do" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${n.noticeNo }">
		제목 : <input type="text" value="${n.noticeTitle }" name="noticeTitle"><br>
		작성자 : <input type="text" value="${n.noticeWriter }" name="noticeWriter"><br>
		첨부파일 : <input type="hidden" name="status" value="stay">
				 <c:if test="${not empty n.filename }">
						<!-- 파일첨부돼있을때, 삭제 버튼을 누르면 첨부 파일이 사라져보이게 delFile 클래스를 이용 -->
						<img src="/resources/upload/notice/${n.filepath }" width="200px" class="delFile">
						<input type="file" name="filename" id="file"
							style="display: none;">
						<!-- 첨부파일이 생기면 생기게할 것. -->
						<span class="delFile">${n.filename }</span>
						<!-- 파일 이름은 String 타입이 아니기 때문에 변경 가능하게 span으로 만듦 -->
						<button type="button" id="fileDelBtn"
							class="delFile">파일삭제</button>
						<input type="hidden" name="oldFilename" value="${n.filename }">
						<input type="hidden" name="oldFilepath" value="${n.filepath }">
					</c:if> 
					<c:if test="${empty n.filename }">
						<input type="file" name="filename">
					</c:if>
		<br>
		내용 : <textarea rows="5" cols="20" name="noticeContent">${n.noticeContent }</textarea>
		<input type="submit" value="등록">
	</form>
</body>
</html>