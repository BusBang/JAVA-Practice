<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="container">
		<h2>1. 다음(카카오) 주소찾기 API</h2>
		<ul>
			<li>
				<!-- 우편번호가 들어가는 칸 -->
				<input type="text" id="postCode" style="width:200px;display:inline-block;" class="form-control" placeholder="우편번호" readonly> 
				<button id ="addrSearchBtn" onclick="addrSearch();" class="btn btn-primary">주소검색</button>
			</li>
			<li>
				<input id="roadAddr" style="width:400px;display:inline-block;" type="text" class="form-control" placeholder="도로명주소">
				<input id="jibunAddr" style="width:400px;display:inline-block;" type="text" class="form-control" placeholder="지번주소">				
			</li>
			<li>
				<input id="detailAddr" style="width:800px;display:inline-block;" type="text" class="form-control" placeholder="상세주소">				
			</li>
		</ul>
	</section>
	<script>
		function addrSearch() {
			new daum.Postcode({
				oncomplete:function(data) { //창을 닫았을 때 실행되는 함수
					$("#postCode").val(data.zonecode);
					$("#roadAddr").val(data.roadAddress);
					$("#jibunAddr").val(data.jibunAddress);
				}
			}).open();
		}
	</script>
	
</body>
</html>
