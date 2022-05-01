<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="layout/header.jsp"%>

<div class="row" style="text-align:center; padding: 100px 100px 0px 0px">
	<h1>관리자 페이지 </h1>
</div>

<div>
	<div class = "row" style="">

		<div class="col-12" style="text-align:right; padding: 100px 100px 100px 100px">
			<form action="adminDashboard" method="post">
				시작일 : <input type="date" name="startdate">
				종료일 : <input type="date" name="enddate">
				시간 간격 :
				<select name="period" >
					<option value = "%Y"> 12개월
					<option value = "%Y-%m"> 1개월
					<option value = "%Y-%m-%d" selected="selected"> 1일
				</select>
				<input type="submit" value="입력">
			</form>	
		</div>
	</div>
	<div class = "row" style="padding: 100px 100px 100px 100px;">
		<div class="col-12" style="text-align:center;">
			<table class="col-10">
				<tr>
					<td> 날짜 </td>
					<td> 방문자수	</td>
					<td> 순방문자수 </td>
					<td> 회원가입수 </td>
					<td> 방문자대비 가입수 </td>
					<td> 구매전환율 (방문자수대비)</td>
					<td> 구매전환율 (순방문자수대비)</td>
					<td> 최다 구매 상품	</td>
					<td> 최다 구매 카테고리</td>
					<td> 최다 유입경로</td>
				</tr>
				<c:forEach items="${cttDtos}" var="dto" >
					<tr>
						<td>${dto.date }</td>
						<td>${dto.pageview}</td>
						<td>${dto.uniquevisitor}</td>
						<td>${dto.signupcount}</td>
						<td>${dto.signupcount/dto.pageview * 100}%</td>
						<td>${dto.ordercount/dto.pageview * 100}%</td>
						<td>${dto.ordercount/dto.uniquevisitor * 100}%</td>
						<td>${dto.p_name}</td>
						<td>${dto.ctg_main } >${dto.ctg_middle } > ${dto.ctg_sub }</td>
						<td>${dto.funnel }</td>
					</tr>
				</c:forEach>
				<tr>
				</tr>
				<tr>
				</tr>		
			</table>
		</div>
		
		
	</div>
</div>


<%@ include file="layout/footer.jsp"%>