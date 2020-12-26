<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//세션정보 모두 파기
	session.invalidate();

%>
<script>
	//사용자를 다시 인덱스 페이지로 보내기
	location.href='index.jsp';
</script>
