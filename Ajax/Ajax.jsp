<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="container">
		<h3>1. ajax로 서버에 전송 값 보내기</h3>
		<p>버튼 클릭 시 전송 값을 서버에서 출력</p>
		<input type="text" class="form-control" id="msg">
		<button class="btn btn-primary" onclick="jsFunction();">보내기(js)</button>
		<button class="btn btn-primary" id="jQ1">보내기(jQuery)</button>
		<h3>2. 버튼 클릭 시 서버에서 보낸 값 수신</h3>
		<button class="btn btn-primary" id="jQ2">서버에서 보낸 값 확인하기</button>
		<p id="p2" class="border border-danger"></p>
		<h3>3. 서버로 기본형 전송값 보내고, 결과로 문자열 받아서 처리</h3>
		<p>숫자 2개를 전송하고 더한 값을 받기</p>
		첫 번째 수 : <input type="text" id="num1"><br>
		두 번째 수 : <input type="text" id="num2"><br>
		<button class="btn btn-primary" id="jQ3">실행</button>
		<p id="p3" class="border border-danger"></p>
 
		<button class="btn btn-primary" id="jQ4">실행</button>
		<h3>5. 서버로 기본형 전송 값을 보내고, 결과로 객체를 받아서 처리</h3>
		<p>JSON 사용</p>
		유저 번호 입력 : <input type="text" id ="userNum"><br>
		<button class="btn btn-primary" id="jQ5">JSON실행</button>		
		<p id="p5" class="border border-danger"></p>
		
		<h3>6. 서버로 기본형 전송값을 보내고, 결과로 리스트를 받아서 처리</h3>
		<p>JSON 사용</p>
		<p>유저 번호를 보내서 해당 유저를 가지고오고, 유저가 없는 경우 전체 리스트 반환</p>
		유저 번호 입력 : <input type="text" id="userNum1"><br>
		<button class="btn btn-primary" id="jQ6">JSON실행</button>	
		<p id="p6" class="border border-danger"></p>
		
		<p>유저 번호들 전송 -> 해당 유저를 맵으로 받아서 처리</p>
		유저 번호 입력 : <input type="text" id="userNum2"><br>
		<button class="btn btn-primary" id="jQ7">JSON실행</button>	
		<p id="p7" class="border border-danger"></p>		
		
		<h3>8. 서버에 값을 보내서, 리스트로 받아 select로 표현</h3>
		<select id = "sel1">
			<option value="1">1</option>
			<option value="2">2</option>			
		</select>
		<select id = "sel2">
		</select>
		
		<h3>9. GSON을 이용한 LIST 반환</h3>
		<button class="btn btn-primary" id="jQ9">GSON실행</button>	
		<p id="p9" class="border border-danger"></p>

		<h3>9. GSON을 이용한 MAP 반환</h3>
		<button class="btn btn-primary" id="jQ10">GSON실행</button>	
		<p id="p10" class="border border-danger"></p>
	</section>
	<script>
		function jsFunction() {
			//1. XMLHttpRequest 객체 생성
			var xhttp = new XMLHttpRequest();
			var msg = document.getElementById("msg").value;
			//2. 요청정보 설정
			xhttp.open("GET","/ajaxTest1?msg="+msg, true);
			//3. 데이터 처리에 따른 동작함수 설정
			xhttp.onreadystatechange = function() {
				if(this.readyState==4 && this.status == 200) {
					console.log("서버 전송 성공");
				}else if(this.readyState == 4 && this.status == 404) {
					//페이지가 없을 때.
					console.log("서버 전송 실패.");
				}
			}
			//4. 서버에 전송
			xhttp.send();
		}
		//jQuery
		$("#jQ1").click(function() {
			var msg = $("#msg").val();
			$.ajax({
				url : "/ajaxText1",
				data : {msg : msg},				
				type : "get",
				success : function() {
					console.log("서버 전송 성공");
				},
				error : function() {
					console.log("서버 전송 실패");
				},
				complete : function() {
					console.log("무조건 호출");
				}
			});
		});
		
		$("#jQ2").click(function() {
			var msg = $("#msg").val();
			$.ajax({
				//전달해줄 값이 없으면 변수는 안 써도 된다.
				url : "/ajaxTest2",
				type : "get",
				data : {msg : msg},
			
				success : function(data) {
					//서버에서 받은 변수가 function의 매개 변수로 들어온다.
					$("#p2").html(data);
				},
				error : function() {
					console.log("실패");
				}
			});
		});
		$("#jQ3").click(function() {
			var num1 = $("#num1").val();
			var num2 = $("#num2").val();
			$.ajax({
				url : "/ajaxTest3",
				data : {num1:num1, num2:num2},
				type : "get",
				success : function(data) {
					$("#p3").html(data);
				},
				error : function(data) {
					console.log("실패");
				}
			});
		});
		$("#jQ4").click(function() {
			var name = $("#name").val();
			var age = $("#age").val();
			var addr = $("#addr").val();
			var user = {name:name, age:age, addr:addr};
			
			$.ajax({
				url : "/ajaxTest4",
				data : user,
				type : "post",
				success : function() {
					console.log("성공^ㅡ^");
				},
				error : function() {
					console.log("실패 ㅠㅠ");
					
				}
			});
		});
		$("#jQ5").click(function() {
			var userNum = $("#userNum").val();
			$.ajax({
				url : "/ajaxTest5",
				type : "get",
				data : {userNum : userNum},
				success : function(data) {
					var userNo = data.userNo;
					var userName = decodeURIComponent(data.userName);
					var userAddr = decodeURIComponent(data.userAddr);
					$("#p5").html("번호 : "+userNo+" / "+"이름 : "+userName+" / "+"주소 : "+userAddr+" / ");
					
				},
				error : function() {
					console.log("실패");
				}
				
			});
		});
		
		$("#jQ6").click(function() {
			var userNum1 = $("#userNum1").val();
			$.ajax({
				url : "/ajaxTest6",
				type : "get",
				data : {userNum1 : userNum1},
				success : function(data) {
					//리스트 반환의 경우 아래와 같은 차이점이 생긴다.
					var resultText = "";
					for(var i=0; i<data.length; i++) {
						var userNo = data[i].userNo;
						var userName = decodeURIComponent(data[i].userName);
						var userAddr = decodeURIComponent(data[i].userAddr);						
						resultText += "번호 : "+userNo+" / "+"이름 : "+userName+" / "+"주소 : "+userAddr+"<br>"
					}
					$("#p6").html(resultText);				
				},
				error : function() {
					console.log("실패");
				}
				
			});
		});
		
		$("#jQ7").click(function() {
			var userNum2 = $("#userNum2").val();
			$.ajax({
				url : "/ajaxTest7",
				type : "get",
				data : {userNum2 : userNum2},
				success : function(data) {
					//리스트 반환의 경우 아래와 같은 차이점이 생긴다.
					var resultText = "";
					var keys = Object.keys(data); //키 값들만 가져와 만듬
					
					for(var i=0; i<keys.length; i++) {
						var userNo = data[keys[i]].userNo;
						var userName = decodeURIComponent(data[keys[i]].userName);
						var userAddr = decodeURIComponent(data[keys[i]].userAddr);						
						resultText += "번호 : "+userNo+" / "+"이름 : "+userName+" / "+"주소 : "+userAddr+"<br>"
					}
					$("#p7").html(resultText);				
				},
				error : function() {
					console.log("실패");
				}
				
			});
		});
		$("#sel1").change(function() {
			var sel1 = $("#sel1").val();
			$.ajax({
				url:"/ajaxTest8",
				data : {sel1 : sel1},
				type : "get",
				success : function(data) {
					var sel2 = $("#sel2");
					sel2.find("option").remove(); //option tag 비워주기
					for(var i=0;i<data.length; i++) {
						var num = data[i].num;
						sel2.append("<option>"+num+"</option>")
					}
				},
				error : function() {
					console.log("Error");
				}
			});
		});

		$("#jQ9").click(function() {
			$.ajax({
				url : "/ajaxTest9",
				type : "get",
				success : function(data) {
					//리스트 반환의 경우 아래와 같은 차이점이 생긴다.
					var resultText = "";
					for(var i=0; i<data.length; i++) {
						var userNo = data[i].userNo;
						var userName = data[i].userName;
						var userAddr = data[i].userAddr;						
						resultText += "번호 : "+userNo+" / "+"이름 : "+userName+" / "+"주소 : "+userAddr+"<br>"
					}
					$("#p9").html(resultText);				
				},
				error : function() {
					console.log("실패");
				}
			});
		});	
		
		$("#jQ10").click(function() {
			$.ajax({
				url : "/ajaxTest10",
				type : "get",
				success : function(data) {
					//리스트 반환의 경우 아래와 같은 차이점이 생긴다.
					var resultText = "";
					var keys = Object.keys(data); //키 값들만 가져와 만듬
					
					for(var key in data) {
						var userNo = data[key].userNo;
						var userName = data[key].userName;
						var userAddr = data[key].userAddr;						
						resultText += "번호 : "+userNo+" / "+"이름 : "+userName+" / "+"주소 : "+userAddr+"<br>"
					}
					$("#p10").html(resultText);				
				},
				error : function() {
					console.log("실패");
				}
				
			});
		});
	</script>
</body>
</html>
