<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="layout/header.jsp" %>
<meta charset="UTF-8">
<title>QnA List Detail</title>
</head>
<body>
	</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>
    #wrapper{
        width:500px;
        margin:auto;
    }
</style>
</head>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<body>
	
	
<div align="center">
	<h5>문의내용</h5>
	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>문의번호</td>
			<td>${QnAContent.pq_id }</td>
		</tr>
		
		<tr>
			<td>User ID</td>
			<td>${QnAContent.u_id}</td>
		</tr>
		
		<tr>
			<td>카테고리</td>
			<td>${QnAContent.qc_name }</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${QnAContent.pq_title }</td>
		</tr>	
		
		<tr>	
			<td>내용</td>
			<td>${QnAContent.pq_content }</td>
		</tr>	
	
	</table><br>
			<h5>답변내용</h5>
	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>답변번호</td>
			<td>${aQnAContent.anq_id }</td>
		</tr>
		
		<tr>
			<td>Admin ID</td>
			<td>${aQnAContent.ad_id }</td>
		</tr>
		
		<tr>
			<td>카테고리</td>
			<td>${aQnAContent.qc_name }</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${aQnAContent.anq_title }</td>
		</tr>	
		
		<tr>	
			<td>내용</td>
			<td>${aQnAContent.anq_content }</td>
		</tr>	
	
	</table>
	<br>
	<form action=""></form>
	<button type="button" onclick="location.href='aQnAWriteView?pq_id=${QnAContent.pq_id }'">답변하기</button>
	<button type="button" onclick="location.href='aQnAList'">목록</button>
</body>
</html>