<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<h1>도서목록</h1>
<table border ="1" cellspacing="0" align="center">
<tr>
	<td>isbn</td>
	<td>제목</td>
	<td>저자</td>
	<td>가격</td>
	<td>설명</td>
</tr>
<c:forEach items="${books}" var="book" >
	<tr>
		<td>${book.isbn}</td>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.price}</td>
		<td>${book.desc}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>