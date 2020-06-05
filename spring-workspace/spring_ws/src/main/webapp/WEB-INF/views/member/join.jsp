<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<body>
	<script type="text/javascript">
		$(function () {
			$("input[name=memberId]").keyup(function () {
				var memberId = $("input[name=memberId]").val();
				$.ajax({
					url : "/checkId.do",
					data : {memberId : memberId},
					type : "get",
					success : function(data) {
						if(data == '0') {
							$("#chkId").html("사용 가능한 아이디입니다.");
						}else {
							$("#chkId").html("사용이 불가능한 아이디입니다.");
						}
					},
					error : function() {
						console.log("ajax 실패");
					}
				});
			});
		});
	</script>
	<form action="/join.do" method="post">
		아이디 : <input type="text" name="memberId"><span id="chkId"></span><br>
		비밀번호 : <input type="text" name="memberPw"><br>
		이름 : <input type="text" name="memberName"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>