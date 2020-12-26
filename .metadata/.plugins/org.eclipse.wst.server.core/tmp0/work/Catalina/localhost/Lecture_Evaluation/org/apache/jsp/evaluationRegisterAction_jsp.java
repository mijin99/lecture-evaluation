/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-26 15:39:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import evaluation.EvaluationDAO;
import evaluation.EvaluationDTO;
import util.SHA256;
import java.io.PrintWriter;

public final class evaluationRegisterAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <!-- 특정 스크립트 구문 출력 -->\r\n");
      out.write("\r\n");

	//로그인 된 상태엔 회원가입 할 수 없음
	request.setCharacterEncoding("UTF-8");
	String userID =null;
	if(session.getAttribute("userID")!=null){
		userID =(String) session.getAttribute("userID");
	}
	if(userID==null){ //로그인 된 사람만 작성가능
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.')");
		script.println("location.href='userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	//테이블 스키마..
	String lectureName=null;
	String professorName=null;
	int lectureYear=0;
	String semesterDivide=null;
	String lectureDivide=null;
	String evaluationTitle=null;
	String evaluationContent=null;
	String totalScore=null;
	String creditScore=null;
	String comfortableScore=null;
	String lectureScore=null;
	
	//사용자로 부터 입력받기
	if(request.getParameter("lectureName")!=null){
		lectureName =request.getParameter("lectureName");
	}
	if(request.getParameter("professorName")!=null){
		professorName =request.getParameter("professorName");
	}
	if(request.getParameter("lectureYear")!=null){
		try{	//입력값은 무조건 문자열이라 변환해줘야함
			lectureYear =Integer.parseInt(request.getParameter("lectureYear"));
		}
		catch(Exception e){
			System.out.println("강의 연도 데이터 오류");
		}
	}
	if(request.getParameter("semesterDivide")!=null){
		semesterDivide =request.getParameter("semesterDivide");
	}
	if(request.getParameter("lectureDivide")!=null){
		lectureDivide =request.getParameter("lectureDivide");
	}
	if(request.getParameter("evaluationTitle")!=null){
		evaluationTitle =request.getParameter("evaluationTitle");
	}
	if(request.getParameter("evaluationContent")!=null){
		evaluationContent =request.getParameter("evaluationContent");
	}
	if(request.getParameter("totalScore")!=null){
		totalScore =request.getParameter("totalScore");
	}
	if(request.getParameter("creditScore")!=null){
		creditScore =request.getParameter("creditScore");
	}
	if(request.getParameter("comfortableScore")!=null){
		comfortableScore =request.getParameter("comfortableScore");
	}
	if(request.getParameter("lectureScore")!=null){
		lectureScore =request.getParameter("lectureScore");
	}
	
	
	if(lectureName ==null || professorName ==null|| lectureYear ==0 ||
		semesterDivide ==null || lectureDivide==null || evaluationTitle ==null ||
		evaluationContent==null||totalScore==null||creditScore==null||comfortableScore==null||
		lectureScore==null|| evaluationTitle.equals("")||evaluationContent.equals("") ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}

	
	EvaluationDAO evaluationDAO =new EvaluationDAO();
	int result = evaluationDAO.write(new EvaluationDTO(0,userID,lectureName,professorName,lectureYear,
									semesterDivide,lectureDivide,evaluationTitle,evaluationContent,totalScore,
									creditScore,comfortableScore,lectureScore,0));
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('강의평가 게시글 등록을 실패했습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}else{
		//바로 로그인 시켜줌. 이메일 인증 페이지 
		session.setAttribute("userID",userID);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href ='index.jsp'");
		script.println("</script>");
		script.close();	
	}


      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}