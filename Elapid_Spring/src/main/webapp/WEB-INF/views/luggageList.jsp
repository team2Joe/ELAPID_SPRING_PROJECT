
<%@page import="java.util.Map"%>
<%@page import="org.springframework.ui.Model"%>
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
			<div class="category-banner0">
				<div class="image-group">
					<div class="image-field">
						<picture>
						<img src="resources/elapid_img/luggage_header.png">
						</picture>
					</div>
					<div class="header-field" align="center">
						<h2>캐리어</h2>
					</div>
				</div>
			</div>

			<div class="div1">
					<h4>필터</h4>
					<br>
					<form action="luggageFilterList">
						<h5>크기</h5>
							기내용/소형 <input type="checkbox" name="ctg_middle" value="small">
							중형수하물 <input type="checkbox" name="ctg_middle" value="middle">
							대형수하물 <input type="checkbox" name="ctg_middle" value="large">
						<br>
						<h5>색상</h5>
							검정 <input type="checkbox" name="ps_color" value="black">
							회색 <input type="checkbox" name="ps_color" value="grey">
							빨강 <input type="checkbox" name="ps_color" value="red">
							흰색 <input type="checkbox" name="ps_color" value="white">
						<br>
						<h5>주요기능</h5>
							서스펜션 휠 <input type="checkbox" name="p_mainf" value="서스펜션휠">
							자동제어장치 <input type="checkbox" name="p_mainf" value="자동제어장치">
							지문인식 <input type="checkbox" name="p_mainf" value="지문인식">
							RFID <input type="checkbox" name="p_mainf" value="rfid">
							<br>
							<input type="submit" value="확인">
					</form>
			</div>
			
			<div class="row row-cols-1 row-cols-md-3 g-4">	
	 			<c:forEach items="${list }" var="dto">
				 <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_id=${dto.p_id }&ctg_middle=${dto.ctg_middle }">
				      <img src="resources/${dto.img_thum }" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>
				        <h6 class="card-price">${dto.p_price } won</h6>
				        <div class="attribute">	
							
						</div>
				      </div>
				      <div class="card-footer">
							<button class="btn btn-dark" onclick = "location.href='addCart?p_id=${dto.p_id}'">장바구니 담기</button>
				      </div>
				    </div>
				  </div>	
				</c:forEach>
			</div>

		<br>
		<div align ="center">
				<tr>
					<td>
						<!-- 페이징 처리 -->
						<c:forEach var="i" begin="1" end="${count }">
							<button onclick="location.href='luggageList?page=${i}'">${i}</button>
						</c:forEach>				

		
					<td>
				</tr>
		</div>		
		<%@ include file="layout/footer.jsp"%>	
		
		
		
		
		
		