<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!--  한글로 -->
    <!-- PUBLIC부터 쭉 지움 -> HTML5 사용을 위해  -->
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
	<section class="container">						<!-- 위로 마진 3 -->
		<form method="get" action="./index.jsp" class="form-inline mt-3">
			<!-- 강의 구분  -->								<!-- 마진 -->
			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select>
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
			<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			<!-- 모달창으로 강의평가 등록하기 -->						<!-- 웹페이지 위쪽 등록양식 -->
			<a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a>
			<a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고</a>
		</form>
		
		
		<!-- 강의평가 등록했을 때 보이는 모습 카드-->
		<div class="card bg-light mt-3">
			<!-- 카드 헤더 -->
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터개론&nbsp;<small>김미진</small></div>
					<div class="col-4 text-right">
						종합<span style="color :red;">A</span>
					</div>
				</div>
			</div>
			
			<!-- 카드 바디부분 -->
			<div class="card-body">
				<h5 class="card-title">
					정말 좋은 강의에요.&nbsp;<small>(2017년 가을학기)</small>
				</h5>
				<p class="card-text">강의나 널널하지만 학점 잘 나오고 좋음. 사바사 있으므로 참고만 바람
				<div class="row">
					<div class="col-9 text-left">
						성적 <span style="color :red;"> A</span>
						널널 <span style="color :red;"> A</span>
						강의 <span style="color :red;"> B</span>
						<span style="color:green;">(추천: 15)</span>
					</div>
					<!-- 추천         텍스트 오른쪽 정렬  -->
					<div class="col-3 text-right">
						<a onclick="return contirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>
						<a onclick="return contirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>
					</div>
				</div>
			</div>	
		</div>
		
		
		<!-- 카드 추가 2 -->
		<!-- 강의평가 등록했을 때 보이는 모습 카드-->
		<div class="card bg-light mt-3">
			<!-- 카드 헤더 -->
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터그래픽스&nbsp;<small>나동빈</small></div>
					<div class="col-4 text-right">
						종합<span style="color :red;">A</span>
					</div>
				</div>
			</div>
			
			<!-- 카드 바디부분 -->
			<div class="card-body">
				<h5 class="card-title">
					완전 꿀강&nbsp;<small>(2018년 2학기)</small>
				</h5>
				<p class="card-text">내용도 재밌고 완전 꿀강임 
				<div class="row">
					<div class="col-9 text-left">
						성적 <span style="color :red;"> A</span>
						널널 <span style="color :red;"> A</span>
						강의 <span style="color :red;"> A</span>
						<span style="color:green;">(추천: 20)</span>
					</div>
					<!-- 추천         텍스트 오른쪽 정렬  -->
					<div class="col-3 text-right">
						<a onclick="return contirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>
						<a onclick="return contirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>
					</div>
				</div>
			</div>	
		</div>
		
		<!-- 카드추가3 -->
		<!-- 강의평가 등록했을 때 보이는 모습 카드-->
		<div class="card bg-light mt-3">
			<!-- 카드 헤더 -->
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터개론&nbsp;<small>김미진</small></div>
					<div class="col-4 text-right">
						종합<span style="color :red;">A</span>
					</div>
				</div>
			</div>
			
			<!-- 카드 바디부분 -->
			<div class="card-body">
				<h5 class="card-title">
					정말 좋은 강의에요.&nbsp;<small>(2017년 가을학기)</small>
				</h5>
				<p class="card-text">강의나 널널하지만 학점 잘 나오고 좋음. 사바사 있으므로 참고만 바람
				<div class="row">
					<div class="col-9 text-left">
						성적 <span style="color :red;"> A</span>
						널널 <span style="color :red;"> A</span>
						강의 <span style="color :red;"> B</span>
						<span style="color:green;">(추천: 15)</span>
					</div>
					<!-- 추천         텍스트 오른쪽 정렬  -->
					<div class="col-3 text-right">
						<a onclick="return contirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>
						<a onclick="return contirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>
					</div>
				</div>
			</div>	
		</div>
		
	</section>
	
	

	<!-- 등록하기 모달창 -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<!-- 모달창임을 알려줌 -->
		<div class="modal-dialog">
			<!-- 모달 창 안에 내용 정의-->
			<div class="modal-content">
				<!-- 헤더와 바디로 구성 -->
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가등록</h5>
					<!-- 닫기버튼 누르면 닫히게 -->
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- 평가 등록 요청 -->
					<form action="./evaluationRegisterAction.jsp" method="post">
						<!-- 하나의 행을 여러개 열로 나눌때  1행-->
						<div class="form-row"> 
							<!-- 컬럼 -->
							<div class="form-group col-sm-6">
								<label>강의명</label>
								<input type="text" name="lectureName" class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>교수명</label>
								<input type="text" name="professorName" class="form-control" maxlength="20">
							
							</div>
						</div>
						
						<!-- 2행 -->
						<div class="form-row">
							<!-- 폼그룹 - 무언가 선택할 때  -->
							<div class="form-group col-sm-4">
								<label>수강 연도</label>
								<select name="lectureYear" class="form-control">
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020" selected>2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="semesterDivide" class="form-control">
									<option value="1학기" selected>1학기 </option>
									<option value="여름학기" >여름학기 </option>
									<option value="2학기" >2학기 </option>
									<option value="겨울학기" >겨울학기 </option>
								</select>
							</div>
							
							<div class="form-group col-sm-4">
								<label>강의 구분</label>
								<select name="lectureDivide" class="form-control">
									<option value="전공" selected>전공 </option>
									<option value="교양" >교양 </option>
									<option value="기타" >기타 </option>
								</select>
							</div>
						</div>
						
						<!-- 실제 강의 평가 내용 3행 -->
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="evaluationTime" class="form-control" maxlength="30">
						</div>
						
						<div class="form-group">
							<label>내용</label>
							<textarea  name="evaluationContext" class="form-control" maxlength="2048" style="height:180px;"></textarea>
						</div>
						
						<!-- 1개의 행을 여러개로 -->
						<div class="form-row">
							<div class="form-group col-sm-3">
							<label>종합</label>
								<select name="totalScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B" selected>B</option>
									<option value="C" selected>C</option>
									<option value="D" selected>D</option>
									<option value="F" selected>F</option>
								</select>
							</div>
							
							<div class="form-group col-sm-3">
							<label>성적</label>
								<select name="creditScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B" selected>B</option>
									<option value="C" selected>C</option>
									<option value="D" selected>D</option>
									<option value="F" selected>F</option>
								</select>
							</div>
							
							<div class="form-group col-sm-3">
							<label>널널</label>
								<select name="comfortableScore" class="form-control">	
									<option value="A" selected>A</option>
									<option value="B" selected>B</option>
									<option value="C" selected>C</option>
									<option value="D" selected>D</option>
									<option value="F" selected>F</option>
								</select>
							</div>
							
							<div class="form-group col-sm-3">
							<label>강의</label>
								<select name="lectureScore" class="form-control">	
									<option value="A" selected>A</option>
									<option value="B" selected>B</option>
									<option value="C" selected>C</option>
									<option value="D" selected>D</option>
									<option value="F" selected>F</option>
								</select>
							</div>
						</div>
						<!-- 모달 헤더, 바디 ,푸터 -->
						<div class="modal-footer">
							<button  type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 신고하기 모달창 -->
	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
			<!-- 모달창임을 알려줌 -->
			<div class="modal-dialog">
				<!-- 모달 창 안에 내용 정의-->
				<div class="modal-content">
					<!-- 헤더와 바디로 구성 -->
					<div class="modal-header">
						<h5 class="modal-title" id="modal">신고하기</h5>
						<!-- 닫기버튼 누르면 닫히게 -->
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- 신고 요청 -->
						<form action="./reportAction.jsp" method="post">
							
							<!-- 실제 강의 평가 내용 3행 -->
							<div class="form-group">
								<label>신고 제목</label>
								<input type="text" name="reportTitle" class="form-control" maxlength="30">
							</div>
							
							<div class="form-group">
								<label>신고 내용</label>
								<textarea  name="reportContent" class="form-control" maxlength="2048" style="height:180px;"></textarea>
							</div>
							
							<!-- 모달 헤더, 바디 ,푸터 -->
							<div class="modal-footer">
								<button  type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								<button type="submit" class="btn btn-danger">신고하기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	<!--					마진탑 4 패딩 5 센터  -->
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