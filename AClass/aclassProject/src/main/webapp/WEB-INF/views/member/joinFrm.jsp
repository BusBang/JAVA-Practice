<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-all">
		<div class="wrap">
			<form class="form" method="post" action="/join.do">
				<span> 회원 가입 </span>
				<div>
					<span>소속 선택</span>
					<select name="deptNo" class="form-control">
						<optgroup label="회사명">												
							<option value="4">KH</option>
							<option value="3">Amazon</option>		
							<option value="2">Apple</option>					
							<option value="1">Google</option>								
						</optgroup>				
					</select>
				</div>
				<div>
					<span>아이디</span><span class="msg"></span>
					<input type="text" class="form-control" name="memberId" placeholder="email 형식 입력" autocomplete="off" required>
				</div>
				<div>
					<span>비밀번호</span><span class="msg"></span>
					<input type="password" class="form-control" name="memberPw" autocomplete="off" required>
				</div>
				<div>
					<span>비밀번호 확인</span><span class="msg"></span>
					<input type="password" class="form-control" id="memberPwRe" autocomplete="off" required>
				</div>
				<div>
					<span>이름</span><span class="msg"></span>
					<input type="text" class="form-control" name="memberName" placeholder="본명을 입력해주세요" autocomplete="off" required>					
				</div>
				<div>
					<span>전화번호</span><span class="msg"></span>
					<input type="text" class="form-control" name="phone" placeholder="010-0000-0000" autocomplete="off" required>
				</div>
				<div style="margin-top:50px;">
					<button type="submit" class="form-control">가입 하기</button>
				</div>
				<div style="text-align:center;">
					<a href="/">메인으로 돌아가기</a>
				</div>				
			</form>
		</div>
	</div>
</body>
</html>