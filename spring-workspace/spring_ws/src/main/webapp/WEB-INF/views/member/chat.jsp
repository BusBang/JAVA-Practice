<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title hereTITLE</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>채팅창</h1>
	<hr>
	<textarea rows="5" cols="30" id="msgArea"></textarea>
	<br>
	메세지 : <input type="text" id="chatMsg"><br>
	상대아이디 : <input type="text" id="target"><br>
	<button id ="sendBtn">전송</button>
	<script>
		var ws;
		var memberId = '${sessionScope.member.memberId}';
		function connect() {
			ws = new WebSocket("ws://192.168.10.179/chat.do");	//protocol이 http가 아닌 ws://임
			//연결 -> 메세지 받았을 때 -> 종료
			//연결
			ws.onopen = function(){
				console.log("웹 소켓 연결 생성");
				//객체 생성
				var msg = {
						type : "register",
						memberId : memberId
				}
				//JSON으로 Object -> String으로 타입 변환해서 보내기
				// "{type : 'register', memberId : 'user01'"}"
				ws.send(JSON.stringify(msg));
			};
			//메세지 수신
			ws.onmessage = function (e) {
				var msg = e.data;
				var chat = $("#msgArea").val()+"\n상대방 : "+msg;
				$("#msgArea").val(chat);
			};
			//종료
			ws.onclose = function () {
				console.log("연결종료")
			};
		}
		$(function() {
			connect();
			
			$("#sendBtn").click(function() {
				var chat = $("#chatMsg").val();
				var msg = $("#msgArea").val()+"\n나 : "+chat;
				$("#msgArea").val(msg);
				var sendMsg = {
						/* 이번엔 type:chat으로 보내줬기 때문에 다른 로직을 탄다. */
						type:"chat", 
						target : $("#target").val(),
						msg : chat
				};
				ws.send(JSON.stringify(sendMsg));
			});
		});
	</script>
</body>
</html>