
<%@page import="com.elapid.spring01.dto.ProductDetailDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	
			<h2 align="center">${detailView.p_id }</h2> <br>
			
			<div align="center">
			<table>
				<tr align="center">
					<%--상품 필터 col --%>
					<td align="center">
						<img src="${detailView.img_01 }" width="400" height="600">
						
					</td>
					<%-- 상품 상세내용 col --%>
					<td align="center">
						<h2> ${detailView.p_name }</h2>
						<h4>가격 : <fmt:formatNumber type="number" value="${detailView.p_price }"/></h4><br>
								
						<br>
						<br>
						남은 수량 : ${detailView.p_stock }<br>
						<button class="btn btn-dark" name="p_id" id="pid" onclick = "inputCart()" value="${detailView.p_id }">장바구니 담기</button>
				      	<br>
						<button onclick="location.href='userOrderForm?p_id=${detailView.p_id } %>'" class="btn btn-dark">바로구매</button>
					</td>
					
				</tr>
				<tr>
					<td align="center">
							<img src="${detailView.img_02 }" width="400" height="600">
							<img src="${detailView.img_03 }" width="400" height="600">
							<img src="${detailView.img_04 }" width="400" height="600">
							<img src="${detailView.img_05 }" width="400" height="600">
							<img src="${detailView.img_06 }" width="400" height="600">
					</td>
					<td>
						<textarea rows="50" cols="50" readonly="readonly">${detailView.p_desc }</textarea> 
					</td>
				</tr>
			</table>
			<br>
			댓글-답글
			<br>		
		
			</div>
			<h3>1:1문의</h3>
			<div class="form-floating">
			  
			  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
			  
			  <label for="floatingTextarea">Comments</label>

			</div>


<%@ include file="layout/footer.jsp"%>	
	