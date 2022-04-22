<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="layout/header.jsp" %>
<meta charset="UTF-8">
</head>
<title>Admin QnA Write</title>

<div align="center">
		<form action="aQnAWrite" >
	<input type="hidden" name="pq_id" value="${write}">
	<div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlInput1"><h6>답변 제목</h6></label>
   	 <input type="text" class="form-control" name="anq_title" >
 	</div>
   	<br>

    <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlTextarea1"><h6>답변 내용</h6></label>
    	<input class="form-control" name="anq_content" style="height:100px;">
  	</div>
		<input type="submit" value="입력">
		<button type="button" onclick="location.href='aQnAList'">목록</button>
	</form>
</div>
</body>
</html>