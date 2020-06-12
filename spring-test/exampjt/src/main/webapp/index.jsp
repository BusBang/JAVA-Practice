<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(function() {
		$("#insertMember").click(function () {
			var id = $('#id').val();
			var name = $('#name').val();
			console.log(id);
			console.log(name);
			$.ajax({
				url : "/insertMember.do",
				data : {id : id,
						name : name},
				type : "get",
				success : function(data) {
					if(data == '1') {
						 $("#msgSpan").html("성공");						
					}else {
						 $("#msgSpan").html("실패");
					}
				},
				error : function () {
					console.log("아작스 실패")
				}
			});
		});	
		
		$("#printMember").click(function () {
			$.ajax({
				url : "/listMember.do",
				success : function (data) {
					html = "";
					$(".memberList").remove();
					for(var i=0; i<data.length; i++) {
						html += "<tr class='memberList'><td>"+data[i].id+"</td>";
						html += "<td>"+data[i].name+"</td>";
						html += "<td>"+data[i].regDate+"</td></tr>";
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

</head>
<body>	
	<form action="/wqe.do" method="post">
		ID : <input type="text" name="id" id="id"><br>
		NAME : <input type="text" name="name" id="name"><br>		
		<button type="button" id="insertMember">메세지입력</button>
		<input type="submit" value="에러테스트">
		<span id="msgSpan"></span>
	</form>
	<hr>
	<button id="printMember">member출력</button>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
	</table>
</body>
</html>