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
${title}<br>
<c:forEach items="${color}" var="ob">
	${ob }<br>
</c:forEach>

<c:forEach var="n" begin="1" end="${num }">
	${n }&nbsp;
</c:forEach><br>
<br><br><br>
테스트글씨
</body>
</html>