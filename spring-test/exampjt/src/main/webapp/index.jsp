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
		$("#insertMsg").click(function () {
			var name = $('#name').val();
			var message = $('#msg').val();
			console.log(name);
			console.log(msg);
			$.ajax({
				url : "/insertMessage.do",
				data : {name : name,
						message : message},
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
		
		$('#printMsg').click(function (){
			var msgTable = $("#msgTable").val();
			$.ajax({
				url : "/listMessage.do",
				data : {message : message},
				type : "get",
				success : function(data) {
					var html = ""l
					for(var i =0; i<data[i])
				},
				error : function () {
					console.log("아작스 실패")
				}				
			});
		});
	});
	
</script>

</head>
<body>
		Name : <input type="text" name="name" id="name"><br>
		MSG : <input type="text" name="message" id="msg"><br>		
		<button id="insertMsg">메세지입력</button>
		<span id="msgSpan"></span>
	<hr>
	<button id="printMsg">메세지출력</button>
	<div id="printMsgDiv">

	
	</div>
</body>
</html>