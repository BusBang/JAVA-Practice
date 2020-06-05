<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function fileDownload(filename,filepath) {
	var newFilename = encodeURIComponent(filename);
	var newFilepath = encodeURIComponent(filepath);
	location.href = "/noticeFileDownload.do?filename="+newFilename+"&filepath="+newFilepath;
}	
</script>
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
			<th>작성일</th>
			<td>${n.regDate}</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<c:if test="${not empty n.filepath}">
					<a href="javascript:fileDownload('${n.filename }','${n.filepath}' )">${n.filename }</a>
				</c:if>			
				<c:if test="${empty n.filepath}">
					첨부파일이 없습니다.
				</c:if>			
			</td>
		</tr>
		<tr>
			<th>파일 이미지</th>
			<td>
				<c:if test="${not empty n.filepath}">
					<img style='width:300px; height:200px;' src="/resources/upload/notice/${n.filepath}">				
				</c:if>
				<c:if test="${empty n.filepath}">
					<img style='width:300px; height:200px;' src="/resources/upload/notice/댕댕이.jpg">				
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