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
<%
	String[] color={"red","green","blue"};
%>

<c:set var="num1" value="${10}"/><!-- int num=10; 과 동일 -->
<c:set var="num2">20</c:set>
num1 + num2 = ${num1+num2}<br><br>

<!-- varStatus:상태변수(count, index, current 등 사용가능) -->
<c:forEach items="<%=color%>" varStatus="i">
	${i.count}&nbsp;&nbsp;&nbsp;${i.current}<br>
</c:forEach>
<br><br><br>

<!-- delims: 구분자 -->
<c:forTokens items="벤츠,페라리,포르쉐,벤틀리,랜드로버" delims="," var="car">
	${car}&nbsp;&nbsp;&nbsp;
</c:forTokens>
<br><br><br>

<!-- 1 2 3 4 5 6 7 8 9 10 -->
<c:forEach begin="1" step="1" end="10" var="num">
	${num}&nbsp;&nbsp;&nbsp;
</c:forEach>

</body>
</html>











