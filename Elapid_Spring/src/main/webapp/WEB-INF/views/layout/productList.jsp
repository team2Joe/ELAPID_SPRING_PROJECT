<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
			<div class="row row-cols-1 row-cols-md-3 g-4">	
	 			<c:forEach items="${list }" var="dto">
				 <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView?p_id=${dto.p_id }&ctg_middle=${dto.ctg_middle }">
				      <img src="/getByteImage" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>						<!-- 가격 천단위로 컴마처리 -->
				        <h6 class="card-price"><fmt:formatNumber type="number" value="${dto.p_price }"/> won</h6>
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