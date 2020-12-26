<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDTO"%>
<%@ page import="user.UserDAO"%>
<%@ page import ="util.SHA256" %>
<%@ page import="java.io.PrintWriter" %> <!-- 특정 스크립트 구문 출력 -->

<%
	//입력받은거 전부 
	request.setCharacterEncoding("UTF-8");
	String userID =null;
	String userPassword =null;
	
	if(request.getParameter("userID")!=null){
		userID =request.getParameter("userID");
	}
	if(request.getParameter("userPassword")!=null){
		userPassword =request.getParameter("userPassword");
	}
	
	if(userID ==null || userPassword ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}

	
	UserDAO userDAO =new UserDAO();
	//로그인 시도
	int result = userDAO.login(userID, userPassword);
	//로그인이 됐다면 리턴1 -> 메인으로 이동
	if(result == 1){
		session.setAttribute("userID",userID);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href='index.jsp'");
		script.println("</script>");
		script.close();
		return;
		//로그인 시도가 틀렸다면.. 
	}else if(result==0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
		script.close();
	}else if(result==-1){
		//존재하지 않는 아이디
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}else if(result==-2){
		//존재하지 않는 아이디
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류가 발생했습니다.')");
		script.println("history.back()");
		script.println("</script>");
		script.close();
	}

%>

