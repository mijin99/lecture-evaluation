/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-27 08:38:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import java.util.Properties;
import user.UserDAO;
import util.SHA256;
import util.Gmail;
import java.io.PrintWriter;

public final class reportAction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  <!-- 메일 라이브러리 전부 사용 -->\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");

//신고시 관리자 이메일로 옴
	UserDAO userDAO =new UserDAO();
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
	String reportTitle =null;
	String reportContent = null;
	if(request.getParameter("reportTitle")!=null){
		reportTitle = request.getParameter("reportTitle");
	}
	if(request.getParameter("reportContent")!=null){
		reportContent = request.getParameter("reportContent");
	}
	if(reportTitle ==null || reportContent ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된 사항이 있습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}
	
	String host="http://localhost:8090/Lecture_Evaluation/";
	String from ="mijinkim92326@gmail.com";
	String to ="mijinkim92326@gmail.com" ; //받는 사람 이메일
	//제목
	String subject ="강의평가 사이트에서 접수된 신고메일입니다.";
	//내용
	String content = "신고자" + userID +
					"<br> 제목 :"+ reportTitle +
					"<br> 내용 :"+ reportContent;
		
		
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
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('정상적으로 신고되었습니다.');");
	script.println("history.back()");
	script.println("</script>");
	script.close();
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
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
