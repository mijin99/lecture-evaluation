
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="user.UserDAO"%>
<%@ page import="evaluation.EvaluationDAO"%>
<%@ page import="likey.LikeyDAO"%>
<%@ page import="java.io.PrintWriter" %> 

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
	if(userID.equals(evaluationDAO.getUserID(evaluationID))){
		int result = new EvaluationDAO().delete(evaluationID);
		if(result==1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('삭제가 완료되었습니다.');");
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
			}
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('자신이 쓴 글만 삭제가 가능합니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
	}
	%>