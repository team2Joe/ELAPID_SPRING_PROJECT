package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.CartOrderDao;
import com.elapid.spring01.dao.OrderDao;
import com.elapid.spring01.dao.UserDao2;
import com.elapid.spring01.dto.RegisterJoinDto;
import com.elapid.spring01.dto.UserDto;

public class EUserOrderCommand implements ECommand {

	
	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		
		OrderDao oDao = new OrderDao();
		CartOrderDao cDao = new CartOrderDao();
		UserDao2 uDao = new UserDao2();
		
		String uid = (String) session.getAttribute("uid");
		int add_id = Integer.parseInt(request.getParameter("uo_address"));		
		String uo_paymentmethod = request.getParameter("uo_paymentmethod");
		
		ArrayList<Integer> p_ids = null;
		// 장바구니에서 선택 상품주문 한 경우 cd_ids 가 같이 넘어 온다.
		if (request.getParameterValues("cd_ids") != null) {
			
			String[] strcd_ids = request.getParameterValues("cd_ids");
			
			ArrayList<Integer> cd_ids = new ArrayList<Integer>(); 
			for(int i = 0 ; i< strcd_ids.length ; i++ ) {
				cd_ids.add(Integer.parseInt(strcd_ids[i]));
			}
			p_ids = cDao.searchBycdids(cd_ids);
			
			// 장바구니 지우기
			oDao.deleteOrderedCart(cd_ids);
		}else {
			// 장바구니 전체 구매나 상품 바로구매의 경우
			
			String[] strp_ids = request.getParameterValues("p_ids");
			p_ids = new ArrayList<Integer>(); 
			for(int i = 0 ; i< strp_ids.length ; i++ ) {
				p_ids.add(Integer.parseInt(strp_ids[i]));
			}
			
		}
		
		int uo_amount = Integer.parseInt(request.getParameter("uo_amount"));
		int uo_discountedamount = Integer.parseInt(request.getParameter("uo_discountedamount"));
		int uo_shippingfee = Integer.parseInt(request.getParameter("uo_shippingfee"));
		
		// 주소록 키값으로 주소 불러오기
		RegisterJoinDto rdto = new RegisterJoinDto();
		rdto = uDao.searchRegister(uid, add_id);
		
		// 주문 테이블 작성 
		oDao.uesrOrderWrite(uid, rdto.getReg_name(),rdto.getReg_tel(), uo_discountedamount, uo_amount, rdto.getAdd_address(), rdto.getReg_specificaddress(),uo_shippingfee,  uo_paymentmethod);
		
		// 가장 최근 주문번호 찾아서 주문 상세 테이블 입력할 떄 같이 넣기  
		int uo_id =  oDao.searchLatestOrderForUser(uid);
		oDao.userOrderDetailWrite(p_ids, uo_id);


	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}

}
