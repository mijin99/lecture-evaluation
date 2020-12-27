<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!--  한글로 -->
    <%@ page import='java.io.PrintWriter' %>
    <!-- PUBLIC부터 쭉 지움 -> HTML5 사용을 위해  -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 반응형웹이기 때문에 뷰 포트에 관련한 메타태그를 넣어줘야함 /디바이스너비                           -->
	<meta name ="viewport" content="width=device-width, initial-scale=1, Shrink-to-fit =no" >
	<title>강의평가 웹사이트</title>
	<!--  부트스트랩 css추가 -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!--  커스텀 css추가 -->
	<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
<%
//로그인에 따른 화면 변경
	String userID =null;
	//로그인 정보가 있으면 받기
	if(session.getAttribute("userID")!=null){
		userID= (String) session.getAttribute("userID");
	}
	if(userID ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.')");
		script.println("location.href='userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
%>
	<!--네비게이션  바 (HTML5부터)/부트스트랩이 제공 밝은 하양바-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<!-- 부트스트랩안에서 로고 같은거 출력 -->
		<a class="navbar-brand" href="index.jsp">강의평가 웹사이트</a>
		<!-- 누르면 navbar id요소가 보였다 안보였다. -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
			<!-- 점 3개 아이콘 -->
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- 버튼 눌러서 나타났다, 사라졌다 하는 부분  #navbar << 이거-->
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">메인</a>
				</li>
				<!-- 누르면 목록나옴 dropdown  -->
				<li class="nav-item dropdown">
				<!-- 눌르면 나타났다 사라졌다.. toggle -->
					<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
						회원관리
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
				<% 	if(userID ==null){ %>
						<a class="dropdown-item" href="userLogin.jsp">로그인</a>
						<a class="dropdown-item" href="userJoin.jsp">회원가입</a>
				<%  }else{ %>
						<a class="dropdown-item" href="userLogout.jsp">로그아웃</a>
				<% } %>
					</div>
				</li>
			</ul>
			<!-- 검색창  -->
			<form action="./index.jsp" method="get" class="form-inline my-2 my-lg-0">
				<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요." aria-label="Search">
					<!-- 전송버튼 -->
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
	</nav>


	<!-- 본문 내용 -->   <!-- 컨테이너 - 반응형 -->
	<section class="container mt-3" style="max-width:560px;">
		<div class="alert alert-warning mt-4" role="alert">
			이메일 주소 인증을 하셔야 이용이 가능합니다. 인증 메일을 받지 못하셨나요?
		</div>	
		<a href="emailSendAction.jsp" class="btn btn-primary">인증메일 다시 받기</a>
	</section>
	
	
	<footer class="bg-dark mt-4 p-5  text-center" style="color: #FFFFFF;">
		Copyright &copy; 2018나동빈 All Rights Reserved.
	</footer>
	
	<!-- 제이쿼리 자바스크립트 추가, 보통 바디 쪽에 아래씀 기본틀 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가-->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가-->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>