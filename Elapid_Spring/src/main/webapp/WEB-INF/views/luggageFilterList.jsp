
<%@page import="com.elapid.spring01.dao.ProductDao"%>
<%@page import="com.elapid.spring01.dto.ProductListDto"%>
<%@page import="com.elapid.spring01.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
   .div1 {
   padding : 0 0 0 100px;
   }
   .div2 {
   padding : 0 0 200px 200px;
   }
</style>
	<br> 	
	<div class="div1">
		<h4>필터</h4>
		
		<form action="luggageFilterList">
			<h5>크기</h5>
				기내용/소형 <input type="checkbox" name="ctg_middle" value="small">
				중형수하물 <input type="checkbox" name="ctg_middle" value="middle">
				대형수하물 <input type="checkbox" name="ctg_middle" value="large">
			
			<h5>색상</h5>
				검정 <input type="checkbox" name="ps_color" value="black">
				회색 <input type="checkbox" name="ps_color" value="grey">
				빨강 <input type="checkbox" name="ps_color" value="red">
				흰색 <input type="checkbox" name="ps_color" value="white">
			
			<h5>주요기능</h5>
				서스펜션 휠 <input type="checkbox" name="p_mainf" value="서스펜션휠">
				자동제어장치 <input type="checkbox" name="p_mainf" value="자동제어장치">
				지문인식 <input type="checkbox" name="p_mainf" value="지문인식">
				RFID <input type="checkbox" name="p_mainf" value="rfid">
				<br>
				<input type="submit" value="확인">
		</form>
	</div>
						
	<%@ include file="layout/productList.jsp" %>
	
		<br>	
		<div align="center">
			<tr>
				<td>
			
	<%
			// get으로 보내줄 기능, 중분류, 색상 3가지 속성값 배열들
			String[] p_mainf = (String[])request.getAttribute("p_mainf");
			String[] ctg_middle = (String[])request.getAttribute("ctg_middle");
			String[] ps_color = (String[])request.getAttribute("ps_color");
			
			// ?뒤에 처음 나와야 할 값
			String getUrl = null;
			
			// 주요기능 필터
			if(p_mainf != null) {
				
				String[] urlValuesMainf = new String[p_mainf.length];
				
				for(int i = 0; i < p_mainf.length; i++) {

						urlValuesMainf[i] = "&p_mainf="+ p_mainf[i];
						getUrl += urlValuesMainf[i];
				}
			}
			// 사이즈 필터
			if(ctg_middle != null) {
				String[] urlValuesMiddle = new String[ctg_middle.length];
				for(int i = 0; i < ctg_middle.length; i++) {
	
						urlValuesMiddle[i] = "&ctg_middle=" + ctg_middle[i];
						getUrl += urlValuesMiddle[i];
				}
			}	
			// 색상 필터
			if(ps_color != null) {
				String[] urlValuesColor = new String[ps_color.length];
				
				for(int i = 0; i < ps_color.length; i++) {

						urlValuesColor[i] = "&ps_color=" + ps_color[i];
						getUrl += urlValuesColor[i];
				}		
			}
			// luggageFilterList 페이지 수
			int count = (Integer)request.getAttribute("count");	
	
			for(int i=1; i<=count; i++){
	%>			
																<%--필터에서 검색해온 get url 정보를 다시 getUrl에
																	넣고 전송 --%>
				<button onclick="location.href='luggageFilterList?<%=getUrl %>&page=<%=i %>'"><%=i %></button>
	<%
			}
	%>
				<td>
			</tr>
		</div>		
			
		<%@ include file="layout/footer.jsp"%>	
		
		
		
		
		
		