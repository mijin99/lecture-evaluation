/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-27 12:55:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.UserDTO;
import user.UserDAO;
import util.SHA256;
import java.io.PrintWriter;

public final class userRegisterAction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" <!-- 특정 스크립트 구문 출력 -->\r\n");
      out.write("\r\n");

	//로그인 된 상태엔 회원가입 할 수 없음
	request.setCharacterEncoding("UTF-8");
	String userID =null;
	if(session.getAttribute("userID")!=null){
		userID =(String) session.getAttribute("userID");
	}
	if(userID!=null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인이 된 상태입니다.')");
		script.println("location.href='index.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	String userPassword =null;
	String userEmail =null;
	if(request.getParameter("userID")!=null){
		userID =request.getParameter("userID");
	}
	if(request.getParameter("userPassword")!=null){
		userPassword =request.getParameter("userPassword");
	}
	if(request.getParameter("userEmail")!=null){
		userEmail =request.getParameter("userEmail");
	}
	if(userID ==null || userPassword ==null||userEmail ==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}

	
	UserDAO userDAO =new UserDAO();
	int result = userDAO.join(new UserDTO(userID,userPassword,userEmail,SHA256.getSHA256(userEmail),false ));
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디입니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}else{
		//바로 로그인 시켜줌. 이메일 인증 페이지 
		session.setAttribute("userID",userID);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href ='emailSendAction.jsp'");
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
