
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<div aligh="center">
<h3>방명록~</h3>
</div>

<%
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto==null){
%>
	<a href="<%= root %>/user?act=register">회원가입</a>
	<a href="<%= root %>/user?act=login">로그인</a>
<%
}else{
%>
	<%=memberDto.getUserName() %>님 안녕하세요!
	<a href="<%= root %>/user?act=logout">호그아웃</a>
	<a href="<%= root %>/user?act=list">리스트<a>
<%
}
%>

</body>
</html>