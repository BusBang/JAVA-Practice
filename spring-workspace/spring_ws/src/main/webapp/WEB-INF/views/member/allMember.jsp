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
			$.ajax({
				url : "/selectAllMember.do",
				success : function (data) {
					html = "";
					$(".memberList").remove();
					for(var i=0; i<data.length; i++) {
						html += "<tr class='memberList'><td>"+data[i].memberId+"</td>";
						html += "<td>"+data[i].memberName+"</td>";
						html += "<td>"+data[i].age+"</td></tr>";
					}
					$("table>tbody").append(html);
				}, 
				error : function() {
					console.log("ajax 실패");
				}
			});
		});
	});
</script>
<body>
	<button id="btn1">전체회원 조회</button>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		
	</table>
</body>
</html>