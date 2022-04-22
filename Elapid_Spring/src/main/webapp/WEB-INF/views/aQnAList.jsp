<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="layout/header.jsp" %>
<meta charset="UTF-8">
<title>Answer Question</title>
<style type="text/css">
div {
	padding: 40px 0 40px 0
	}
</style>
</head>
<body>
	
	<div align="center">
	<table width="700" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>카테고리</td>
		<td>제목</td>
		<td>내용</td>
		<td>User ID</td>
		<td>답변상태</td>
	<tr>
	<c:forEach items="${aQnAList }" var="dtos">
	<tr>
		<td>${dtos.pq_id }</td>
		<td>${dtos.qc_name }</td>
		<td>${dtos.pq_title }</td>
		<td>${dtos.pq_content }</td>
		<td>${dtos.u_id }</td>
		<td>${dtos.anq_state }</td>
		<td><button type="button" onclick="location.href='aQnAContent?pq_id=${dtos.pq_id }'">확인하기</button></td>
	</tr>
	</c:forEach> 
	</table>
	</div>	
</body>
</html>