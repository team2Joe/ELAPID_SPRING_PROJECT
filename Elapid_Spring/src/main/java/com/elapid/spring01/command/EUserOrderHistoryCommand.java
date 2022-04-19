package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.OrderDao;
import com.elapid.spring01.dto.OrderHistoryDto;

public class EUserOrderHistoryCommand implements ECommand {

	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		String uid = (String)session.getAttribute("uid");
		
		
		OrderDao dao = new OrderDao();
		ArrayList<OrderHistoryDto> dtos = new ArrayList<OrderHistoryDto>();
		
		dtos = dao.userOrderHistory(uid);
		
		request.setAttribute("orderHistory", dtos);
		
		System.out.println( request.getParameter("pageNum") + "***********");
		
		if (request.getParameter("pageNum") != null) {
			
			request.setAttribute("pageNumtwo",Integer.parseInt(request.getParameter("pageNum")));
		}else {
			request.setAttribute("pageNumtwo", 1);
		}
		request.setAttribute("pageNumtwo", 1);
	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}

}
