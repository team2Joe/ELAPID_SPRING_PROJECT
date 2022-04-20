<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StayCartPage</title>
</head>
<body>
	<%
		String url = request.getHeader("referer");
		response.sendRedirect(url);
	%>
	
</body>
</html>