<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name=request.getParameter("irum");  // hello.jsp?irum=kim
%><br>
Hello!! <b><%=name%></b>님 환영합니다
</body>
</html>
















