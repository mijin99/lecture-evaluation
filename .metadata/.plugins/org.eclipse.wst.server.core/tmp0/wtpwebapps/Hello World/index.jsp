<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>우리의 첫 번째 페이지</title>
</head>
<body>
	Hello world
	<!--  폼 안에서 버튼을 눌렀을때 어디로 갈지 jsp페이지 연결  -->
	<form action="./userJoinAction.jsp" method="post">
		<input type="text" name="userID">
		<input type="password" name="userPassword">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>