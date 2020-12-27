<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="user.UserDAO"%>
<%@ page import="evaluation.EvaluationDAO"%>
<%@ page import="likey.LikeyDAO"%>
<%@ page import="java.io.PrintWriter" %> 
<%!
	//내부 함수 선언.. ip를 가져온다.
	public static String getClientIP(HttpServletRequest request){
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip==null||ip.length()==0){
			ip =request.getHeader("Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0){
			ip =request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0){
			ip =request.getRemoteAddr();
		}
		return ip;
	}
%>
<%
	//로그인 안하면 좋아요 못함
	String userID =null;
	if(session.getAttribute("userID")!=null){
		userID =(String)session.getAttribute("userID");
	}
	if(userID ==null){ //로그인이 안돼있음 로그인시킴
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.');");
		script.println("location.href='userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	//요청 받기
	request.setCharacterEncoding("UTF-8");
	String evaluationID =null;
	if(request.getParameter("evaluationID")!=null){
		evaluationID = request.getParameter("evaluationID");
	}
	EvaluationDAO evaluationDAO = new EvaluationDAO();
	LikeyDAO likeyDAO =new LikeyDAO();
	//IP얻어오기
	int result=likeyDAO.like(userID,evaluationID,getClientIP(request));
	//추천이 눌려짐
	if(result ==1){
		//특정 강의평가 글 늘려주기
		result= evaluationDAO.like(evaluationID);
		if(result ==1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('추천이 왼료되었습니다.');");
			script.println("location.href='index.jsp'");
			script.println("</script>");
			script.close();
			return;
		}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.');");
			script.println("history.back()");
			script.println("</script>");
			script.close();
			return;
		}
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 추천을 누른 글입니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		
	}
	
	
%>
	
	
	

