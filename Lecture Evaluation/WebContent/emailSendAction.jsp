<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="javax.mail.Transport" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.Message" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.Address" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.internet.InternetAddress" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.internet.MimeMessage" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.Session" %> <!-- 메일 라이브러리 전부 사용 -->
 <%@ page import ="javax.mail.Authenticator" %> <!-- 메일 라이브러리 전부 사용 -->
  <%@ page import ="java.util.Properties" %>
<%@ page import="user.UserDAO"%>
<%@ page import ="util.SHA256" %>
 <%@ page import ="util.Gmail" %>
<%@ page import="java.io.PrintWriter" %> 

<%
	UserDAO userDAO =new UserDAO();
	String userID =null;
	if(session.getAttribute("userID")!=null){
		userID =(String)session.getAttribute("userID");
	}
	if(userID ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.');");
		script.println("location.href='userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	boolean emailChecked = userDAO.getUserEmailChecked(userID);
	if(emailChecked ==true){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 인증 된 회원입니다.');");
		script.println("location.href='index.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	String host="http://localhost:8090/Lecture_Evaluation/";
	String from ="mijinkim92326@gmail.com";
	String to = userDAO.getUserEmail(userID); //받는 사람 이메일
	//제목
	String subject ="강의평가를 위한 이메일 인증 메일입니다.";
	//내용
	String content = "다음 링크에 접속하여 인증을 진행하세요." +
		"<a href='" + host +"emailCheckAction.jsp?code="+ new SHA256().getSHA256(to)+ "'>이메일 인증하기 </a>";
		
	//메일 보내기 위한 구글 smtp 허용 과정
	Properties p =new Properties();
	p.put("mail.smtp.user",from);
	p.put("mail.smtp.host","smtp.googlemail.com");
	p.put("mail.smtp.port","465"); //포트
	p.put("mail.smtp.starttls.enable","true");
	p.put("mail.smtp.auth","true");
	p.put("mail.smtp.debug","true");
	p.put("mail.smtp.socketFactory.port","465");
	p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback","false");	
	
	//인증메시지 보내기
	try{
		//실제 인증을 수행해 관리자의
		Authenticator auth = new Gmail();
		Session ses= Session.getInstance(p,auth);
		ses.setDebug(true);
		MimeMessage  msg = new MimeMessage(ses);
		msg.setSubject(subject);
		//보내는사람
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr);
		//받는사람
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO,toAddr);
		
		msg.setContent(content,"text/html;charset=UTF-8");
		Transport.send(msg);
	}catch(Exception e){
		e.printStackTrace();
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('오류가 발생했습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}
	%>
	
	
	
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
						<a class="dropdown-item" href="userLogin.jsp">로그인</a>
						<a class="dropdown-item" href="userJoin.jsp">회원가입</a>
						<a class="dropdown-item" href="userLogout.jsp">로그아웃</a>
					</div>
				</li>
			</ul>
			<!-- 검색창  -->
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요." aria-label="Search">
					<!-- 전송버튼 -->
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
	</nav>

	<!-- 본문 내용 -->   <!-- 컨테이너 - 반응형 -->
	<section class="container mt-3" style="max-width:560px;">
		<div class="alert alert-success mt-4" role="alert">
			이메일 주소 인증 메일이 전송되었습니다. 회원가입시 입력했던 이메일에 들어가셔서 인증해주세요.
		</div>			
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
	
	

