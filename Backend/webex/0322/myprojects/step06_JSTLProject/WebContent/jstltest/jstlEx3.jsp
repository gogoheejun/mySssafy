<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
<form action=""  method="post">
	반복하고싶은문구 : <input type="text" name="str" ><br>
	반복하고싶은횟수 : <input type="text" name="num"><br>
	<input type="submit" value="실행">
</form><br>



<c:forEach begin="1" end="${param.num}">
	${param.str}<br>
</c:forEach>
</body>
</html>