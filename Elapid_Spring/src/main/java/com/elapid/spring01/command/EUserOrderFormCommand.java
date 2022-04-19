package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.OrderDao;
import com.elapid.spring01.dto.ProductListDto;
import com.elapid.spring01.dto.RegisterJoinDto;
import com.elapid.spring01.dto.UserDto;
import com.elapid.spring01.dao.UserDao2;

public class EUserOrderFormCommand implements ECommand {

	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		
		UserDao2 dao = new UserDao2();
		String uid = (String) session.getAttribute("uid");
		UserDto userDto = dao.profileView(uid);
		
		
		ArrayList<RegisterJoinDto> shipDtos = new ArrayList<RegisterJoinDto>();
		
		
		userDto = dao.profileView(uid);
		shipDtos = dao.searchRegisterForUser(uid);
		
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		int p_id = -1;
		
		// 상품 하나 바로 구매
		try {
			p_id = Integer.parseInt(request.getParameter("p_id"));
			
		}catch(Exception e) {
			//e.printStackTrace();
			
		}
		
		
		// 장바구니 선택 주문, 전체 주문
		if(p_id == -1) {
			
			p_ids = (ArrayList<Integer>) request.getAttribute("p_ids");
			
		}else {
			
			p_ids.add(p_id);
			
		}
		
				
//		p_ids.add(1);
//		p_ids.add(2);
//		
//		System.out.println(p_ids.get(1));
		
		OrderDao orderDao = new OrderDao();
		ArrayList<ProductListDto> pListDtos = orderDao.productsInfo(p_ids);
		
		request.setAttribute("pListDtos", pListDtos);
		request.setAttribute("registerDtos", shipDtos);
		request.setAttribute("userDto", userDto);
	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
	}


}
