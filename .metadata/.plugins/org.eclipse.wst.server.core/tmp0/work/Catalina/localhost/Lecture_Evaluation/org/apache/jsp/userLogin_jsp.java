/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-26 14:31:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;

public final class userLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" <!--  한글로 -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- PUBLIC부터 쭉 지움 -> HTML5 사용을 위해  -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<!-- 반응형웹이기 때문에 뷰 포트에 관련한 메타태그를 넣어줘야함 /디바이스너비                           -->\r\n");
      out.write("\t<meta name =\"viewport\" content=\"width=device-width, initial-scale=1, Shrink-to-fit =no\" >\r\n");
      out.write("\t<title>강의평가 웹사이트</title>\r\n");
      out.write("\t<!--  부트스트랩 css추가 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n");
      out.write("\t<!--  커스텀 css추가 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./css/custom.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

//로그인에 따른 화면 변경
	String userID =null;
	//로그인 정보가 있으면 받기
	if(session.getAttribute("userID")!=null){
		userID= (String) session.getAttribute("userID");
	}
	if(userID !=null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인이 된 상태입니다.')");
		script.println("location.href='index.jsp'");
		script.println("</script>");
		script.close();
		return;
	}

      out.write("\r\n");
      out.write("\t<!--네비게이션  바 (HTML5부터)/부트스트랩이 제공 밝은 하양바-->\r\n");
      out.write("\t<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("\t\t<!-- 부트스트랩안에서 로고 같은거 출력 -->\r\n");
      out.write("\t\t<a class=\"navbar-brand\" href=\"index.jsp\">강의평가 웹사이트</a>\r\n");
      out.write("\t\t<!-- 누르면 navbar id요소가 보였다 안보였다. -->\r\n");
      out.write("\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar\">\r\n");
      out.write("\t\t\t<!-- 점 3개 아이콘 -->\r\n");
      out.write("\t\t\t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t<!-- 버튼 눌러서 나타났다, 사라졌다 하는 부분  #navbar << 이거-->\r\n");
      out.write("\t\t<div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item active\">\r\n");
      out.write("\t\t\t\t\t<a class=\"nav-link\" href=\"index.jsp\">메인</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<!-- 누르면 목록나옴 dropdown  -->\r\n");
      out.write("\t\t\t\t<li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t\t\t<!-- 눌르면 나타났다 사라졌다.. toggle -->\r\n");
      out.write("\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" id=\"dropdown\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t회원관리\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"dropdown\">\r\n");
      out.write("\t\t\t\t");
 	if(userID ==null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"userLogin.jsp\">로그인</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"userJoin.jsp\">회원가입</a>\r\n");
      out.write("\t\t\t\t");
  }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"userLogout.jsp\">로그아웃</a>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<!-- 검색창  -->\r\n");
      out.write("\t\t\t<form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("\t\t\t\t<input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"내용을 입력하세요.\" aria-label=\"Search\">\r\n");
      out.write("\t\t\t\t\t<!-- 전송버튼 -->\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">검색</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 본문 내용 -->   <!-- 컨테이너 - 반응형 -->\r\n");
      out.write("\t<section class=\"container mt-3\" style=\"max-width:560px;\">\r\n");
      out.write("\t\t<!-- 로그인 요청시 페이지 이동 -->\t\t\t\t\t\r\n");
      out.write("\t\t<form method=\"post\" action=\"./userLoginAction.jsp\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label>아이디</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"userID\" class=\"form-control\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label>비밀번호</label>\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"userPassword\" class=\"form-control\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-primary\">로그인</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<footer class=\"bg-dark mt-4 p-5  text-center\" style=\"color: #FFFFFF;\">\r\n");
      out.write("\t\tCopyright &copy; 2018나동빈 All Rights Reserved.\r\n");
      out.write("\t</footer>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 제이쿼리 자바스크립트 추가, 보통 바디 쪽에 아래씀 기본틀 -->\r\n");
      out.write("\t<script src=\"./js/jquery.min.js\"></script>\r\n");
      out.write("\t<!-- 파퍼 자바스크립트 추가-->\r\n");
      out.write("\t<script src=\"./js/popper.js\"></script>\r\n");
      out.write("\t<!-- 부트스트랩 자바스크립트 추가-->\r\n");
      out.write("\t<script src=\"./js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
