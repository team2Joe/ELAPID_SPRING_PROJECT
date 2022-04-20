<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<a href="luggageList"><img src="resources/elapid_img/indexMain.jpeg" width="100%"></a>

<div class="accordion" id="accordionExample" align="center">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button onclick="location.href='interestedProductList'" class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        조회수 상품 TOP 3
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
		<div class="row row-cols-1 row-cols-md-3 g-4">	
	 			<c:forEach items="${list }" var="dto">
				 <div class="col">
				    <div class="card h-100" align="center">
				    <%--순위 반영 --%>
				    <c:choose>
				    	<c:when test="${dto.p_rank eq 1 }">
				    		<p class="text-warning bg-grey">Top${dto.p_rank }</p>
				    	</c:when>
				    	<c:otherwise>
				    		<p class="text-info bg-grey">Top${dto.p_rank }</p>		    		
				    	</c:otherwise>
				    </c:choose>
			    	  <a href="detailView?p_id=${dto.p_id }&ctg_middle=${dto.ctg_middle }">
				      <img src="${dto.img_thum }" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>
				        <h6 class="card-price">${dto.p_price } won</h6>
				        <div class="attribute">	
							
						</div>
				      </div>
				      <div class="card-footer">
				 	<%-- 아이디값 null시 비회원 장바구니로 들어가기 --%>
							<button class="btn btn-dark" onclick = "location.href='addCart?p_id=${dto.p_id}'">장바구니 담기</button>
				      </div>
				    </div>
				  </div>	
				</c:forEach>
			</div>
      </div>
    </div>
  </div>
</div>  

<%@ include file="layout/footer.jsp" %>	
