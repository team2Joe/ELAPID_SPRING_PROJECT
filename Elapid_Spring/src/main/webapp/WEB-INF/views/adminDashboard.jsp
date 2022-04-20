<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="layout/header.jsp"%>

<div class="row" style="text-align:center; padding: 100px 100px 0px 0px">
	<h1>관리자 페이지 </h1>
</div>

<div>
	<div class = "row" style="">
		<div style="text-align:right;">
			<form action="adminDashboard" method="get">
				시작일 : <input type="date" name="startdate">
				종료일 : <input type="date" name="enddate">
				<input type="submit" value="날짜 입력">
			</form>	
		</div>
		<table>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>		
		
		
		</table>
	</div>
</div>


<%@ include file="layout/footer.jsp"%>