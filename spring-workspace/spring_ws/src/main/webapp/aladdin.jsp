<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(function () {

		$("#btn1").click(function () {
			var title = $("#title").val();
			$.ajax({
				url : "/aladdin.do",
				type : "get",
				data : {title : title},
				success : function (data) {
					html = "";
					console.log(data);
					for(var i=0; i<data.length; i++) {
						html += "<tr><td><img src='"+data[i].cover+"'></td>";
						html += "<td>"+data[i].title+"</td>";
						html += "<td>"+data[i].author+"</td>";
						html += "<td>"+data[i].pubDate+"</td>";
						html += "<td>"+data[i].publisher+"</td>";
						html += "<td>"+data[i].categoryId+"</td>";
						html += "<td>"+data[i].categoryName+"</td>";
						html += "<td>"+data[i].description+"</td>";
					}
					$("table>tbody").append(html);
				}, 
				error : function(data) {
					console.log("ajax 실패");
					console.log(data)
				}
			});
		});
	});
</script>
<body>
	<br>
		책이름 : <input type="text" name="title" id="title">
		<button type="button" id="btn1">검색</button>
<!-- 		<a href="/베스트셀러.xlsx">다운로드</a> -->
	<hr>
	<table border="1">
		<tr>
			<th>cover</th>		
			<th>title</th>
			<th>author</th>
			<th>pubDate</th>
			<th>publisher</th>
			<th>categoryId</th>
			<th>categoryName</th>
			<th>description</th>
		</tr>
	</table>
</body>
</html>