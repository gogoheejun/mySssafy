<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="color" value="${'greeen'}"/>
<c:choose>
	<c:when test="${color=='red'}">빨간색</c:when>
	<c:when test="${color=='green'}">초록색</c:when>
	<c:when test="${color=='blue'}">파랑색</c:when>
<%-- 	<c:otherwise>기타색</c:otherwise>   --%>
	<c:otherwise><c:out value='기타색'/></c:otherwise>
</c:choose>   <!-- or  <c:out value='기타색'/> -->
</body>
</html>