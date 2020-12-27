/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-27 14:11:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import user.UserDAO;
import evaluation.EvaluationDTO;
import evaluation.EvaluationDAO;
import java.util.ArrayList;
import java.net.URLEncoder;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!-- PUBLIC부터 쭉 지움 -> HTML5 사용을 위해  -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- 로그인 상태에 따라 보여지는 항목을 바꾸기 위해 -->\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
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

//검색게시물
	request.setCharacterEncoding("UTF-8");
	String lectureDivide ="전체";
	String searchType="최신순";
	String search ="";
	int pageNumber=0;
	if(request.getParameter("lectureDivide")!=null){
		lectureDivide = request.getParameter("lectureDivide");
	}
	if(request.getParameter("searchType")!=null){
		searchType = request.getParameter("searchType");
	}
	if(request.getParameter("search")!=null){
		search = request.getParameter("search");
	}
	if(request.getParameter("pageNumber")!=null){
		try{
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		catch(Exception e){
			System.out.println("검색페이지 오류");
		}
	}
	

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
	//이메일 인증이 안된 사람이 접속하려하면 인증페이지로 
	boolean emailChecked = new UserDAO().getUserEmailChecked(userID);
	if(emailChecked ==false){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		//인증이 안된사람이 인증페이지로 
		script.println("location.href='emailSendConfirm.jsp'");
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
      out.write("\t\t\t<form action=\"./index.jsp\" method=\"get\" class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"search\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"내용을 입력하세요.\" aria-label=\"Search\">\r\n");
      out.write("\t\t\t\t\t<!-- 전송버튼 -->\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">검색</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 본문 내용 -->   <!-- 컨테이너 - 반응형 -->\r\n");
      out.write("\t<section class=\"container\">\t\t\t\t\t\t<!-- 위로 마진 3 -->\r\n");
      out.write("\t\t<form method=\"get\" action=\"./index.jsp\" class=\"form-inline mt-3\">\r\n");
      out.write("\t\t\t<!-- 강의 구분  -->\t\t\t\t\t\t\t\t<!-- 마진 -->\r\n");
      out.write("\t\t\t<select name=\"lectureDivide\" class=\"form-control mx-1 mt-2\">\r\n");
      out.write("\t\t\t\t<option value=\"전체\">전체</option>\r\n");
      out.write("\t\t\t\t<option value=\"전공\" ");
if(lectureDivide.equals("전공")) out.println("selected"); 
      out.write(">전공</option>\r\n");
      out.write("\t\t\t\t<option value=\"교양\" ");
if(lectureDivide.equals("교양")) out.println("selected"); 
      out.write(">교양</option>\r\n");
      out.write("\t\t\t\t<option value=\"기타\" ");
if(lectureDivide.equals("기타")) out.println("selected"); 
      out.write(">기타</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<select name=\"searchType\" class=\"form-control mx-1 mt-2\">\r\n");
      out.write("\t\t\t\t<option value=\"최신순\" >최신순</option>\r\n");
      out.write("\t\t\t\t<option value=\"추천순\" ");
if(searchType.equals("추천순")) out.println("selected"); 
      out.write(">추천순</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"search\" class=\"form-control mx-1 mt-2\" placeholder=\"내용을 입력하세요\">\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-primary mx-1 mt-2\">검색</button>\r\n");
      out.write("\t\t\t<!-- 모달창으로 강의평가 등록하기 -->\t\t\t\t\t\t<!-- 웹페이지 위쪽 등록양식 -->\r\n");
      out.write("\t\t\t<a class=\"btn btn-primary mx-1 mt-2\" data-toggle=\"modal\" href=\"#registerModal\">등록하기</a>\r\n");
      out.write("\t\t\t<a class=\"btn btn-danger mx-1 mt-2\" data-toggle=\"modal\" href=\"#reportModal\">신고</a>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t");

	//사용자가 검색을 한 내용이 리스트레 담겨서 출력
	ArrayList<EvaluationDTO> evaluationList = new ArrayList<EvaluationDTO>();
	evaluationList = new EvaluationDAO().getList(lectureDivide,searchType,search,pageNumber);
	if(evaluationList !=null)
		for(int i=0;i<evaluationList.size();i++){
			if(i==5) break;
			EvaluationDTO evaluation =evaluationList.get(i);
		
	
	
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 강의평가 등록했을 때 보이는 모습 카드-->\r\n");
      out.write("\t\t<div class=\"card bg-light mt-3\">\r\n");
      out.write("\t\t\t<!-- 카드 헤더 -->\r\n");
      out.write("\t\t\t<div class=\"card-header bg-light\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-8 text-left\">");
      out.print( evaluation.getLectureName() );
      out.write("&nbsp;<small>");
      out.print( evaluation.getProfessorName() );
      out.write("</small></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-4 text-right\">\r\n");
      out.write("\t\t\t\t\t\t종합<span style=\"color :red;\">");
      out.print( evaluation.getTotalScore() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 카드 바디부분 -->\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( evaluation.getEvaluationTitle() );
      out.write("&nbsp;<small>(");
      out.print(evaluation.getLectureYear() );
      out.write('년');
      out.write(' ');
      out.print(evaluation.getSemesterDivide() );
      out.write(")</small>\r\n");
      out.write("\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">");
      out.print( evaluation.getEvaluationContent() );
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-9 text-left\">\r\n");
      out.write("\t\t\t\t\t\t성적 <span style=\"color :red;\"> ");
      out.print( evaluation.getCreditScore());
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t널널 <span style=\"color :red;\"> ");
      out.print( evaluation.getComfortableScore() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t강의 <span style=\"color :red;\"> ");
      out.print( evaluation.getLectureScore());
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t<span style=\"color:green;\">(추천 : ");
      out.print( evaluation.getLikeCount());
      out.write(" )</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- 추천         텍스트 오른쪽 정렬  -->\r\n");
      out.write("\t\t\t\t\t<div class=\"col-3 text-right\">\r\n");
      out.write("\t\t\t\t\t\t<a onclick=\"return contirm('추천하시겠습니까?')\" href=\"./likeAction.jsp?evaluationID=");
      out.print( evaluation.getEvaluationID());
      out.write("\">추천</a>\r\n");
      out.write("\t\t\t\t\t\t<a onclick=\"return contirm('삭제하시겠습니까?')\" href=\"./deleteAction.jsp?evaluationID=");
      out.print( evaluation.getEvaluationID());
      out.write("\">삭제</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 카드 한개 끝 -->\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 페이지 네이션  --><!--부트스트랩 웹디자인 프레임워크에서 제공. 여러 개의 페이지가 있는 하나의 구성요소 // 게시판많이 사용 -->\r\n");
      out.write("\t<ul class=\"pagination justify-content-center mt-3\">\r\n");
      out.write("\t\t<li class=\"page-item\">\r\n");
      out.write("\t");

	if(pageNumber <=0){
		
      out.write("\r\n");
      out.write("\t\t<a class=\"page-link disabled\">이전</a>\r\n");
      out.write("\t\t");

	}else{
	
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- 특정 url이동시엔 인코더 이용 -->\r\n");
      out.write("\t\t<a class=\"page-link\" href=\"./index.jsp?lectureDivide=");
      out.print( URLEncoder.encode(lectureDivide,"UTF-8") );
      out.write("&searchType=\r\n");
      out.write("\t\t");
      out.print( URLEncoder.encode(searchType,"UTF-8") );
      out.write(" &search =");
      out.print( URLEncoder.encode(search,"UTF-8") );
      out.write("&pageNumber =");
      out.print(pageNumber -1 );
      out.write("\">이전</a>\r\n");
		
	}

      out.write("\t\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

		//현재 상태에서 6개  -> 다음페이지가 존재. 
	if(evaluationList.size()<6){
		
      out.write("\r\n");
      out.write("\t\t<a class=\"page-link disabled\">다음</a>\r\n");
      out.write("\t\t");

	}else{
	
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t<a class=\"page-link\" href=\"./index.jsp?lectureDivide=");
      out.print( URLEncoder.encode(lectureDivide,"UTF-8") );
      out.write("&searchType=\r\n");
      out.write("\t\t");
      out.print( URLEncoder.encode(searchType,"UTF-8") );
      out.write(" &search =");
      out.print( URLEncoder.encode(search,"UTF-8") );
      out.write("&pageNumber =");
      out.print(pageNumber +1 );
      out.write("\">다음</a>\r\n");
		
	}

      out.write("\t\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 등록하기 모달창 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"registerModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<!-- 모달창임을 알려줌 -->\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<!-- 모달 창 안에 내용 정의-->\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<!-- 헤더와 바디로 구성 -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"modal-title\" id=\"modal\">평가등록</h5>\r\n");
      out.write("\t\t\t\t\t<!-- 닫기버튼 누르면 닫히게 -->\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<!-- 평가 등록 요청 -->\r\n");
      out.write("\t\t\t\t\t<form action=\"./evaluationRegisterAction.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 하나의 행을 여러개 열로 나눌때  1행-->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\"> \r\n");
      out.write("\t\t\t\t\t\t\t<!-- 컬럼 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>강의명</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"lectureName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>교수명</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"professorName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 2행 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 폼그룹 - 무언가 선택할 때  -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>수강 연도</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"lectureYear\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2011\">2011</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2012\">2012</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2013\">2013</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2014\">2014</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2015\">2015</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2016\">2016</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2017\">2017</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2018\">2018</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2019\">2019</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2020\" selected>2020</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2021\">2021</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2022\">2022</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2023\">2023</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>수강 학기</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"semesterDivide\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1학기\" selected>1학기 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"여름학기\" >여름학기 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2학기\" >2학기 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"겨울학기\" >겨울학기 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>강의 구분</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"lectureDivide\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"전공\" selected>전공 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"교양\" >교양 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"기타\" >기타 </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 실제 강의 평가 내용 3행 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>제목</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"evaluationTitle\" class=\"form-control\" maxlength=\"30\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>내용</label>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea  name=\"evaluationContent\" class=\"form-control\" maxlength=\"2048\" style=\"height:180px;\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 1개의 행을 여러개로 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>종합</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"totalScore\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>성적</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"creditScore\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>널널</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"comfortableScore\" class=\"form-control\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>강의</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"lectureScore\" class=\"form-control\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"A\" selected>A</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"B\" >B</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"C\" >C</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"D\" >D</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"F\" >F</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- 모달 헤더, 바디 ,푸터 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t<button  type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">등록하기</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 신고하기 모달창 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"reportModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t<!-- 모달창임을 알려줌 -->\r\n");
      out.write("\t\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t\t<!-- 모달 창 안에 내용 정의-->\r\n");
      out.write("\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t<!-- 헤더와 바디로 구성 -->\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t<h5 class=\"modal-title\" id=\"modal\">신고하기</h5>\r\n");
      out.write("\t\t\t\t\t\t<!-- 닫기버튼 누르면 닫히게 -->\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 신고 요청 -->\r\n");
      out.write("\t\t\t\t\t\t<form action=\"./reportAction.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 실제 강의 평가 내용 3행 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>신고 제목</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"reportTitle\" class=\"form-control\" maxlength=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>신고 내용</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea  name=\"reportContent\" class=\"form-control\" maxlength=\"2048\" style=\"height:180px;\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 모달 헤더, 바디 ,푸터 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button  type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-danger\">신고하기</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<!--\t\t\t\t\t마진탑 4 패딩 5 센터  -->\r\n");
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
