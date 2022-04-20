<%@page import="com.elapid.spring01.dao.ProductDao"%>
<%@page import="com.elapid.spring01.dto.ProductListDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

    	<%--상품 카드 부분 --%>
			<%@ include file="layout/productList.jsp" %>
		
		<br>		
		<div align="center">
			<tr>
				<td>
			
	<%
 			int count = (int)request.getAttribute("count");	
	
 			for(int i=1; i<=count; i++){
	%>			
				<button onclick="location.href='middleFunctionList.do?page=<%=i %>'"><%=i %></button>
	<%
 			}
	%> 
				<td>
			</tr>
		</div>	
		<%@ include file="layout/footer.jsp"%>	