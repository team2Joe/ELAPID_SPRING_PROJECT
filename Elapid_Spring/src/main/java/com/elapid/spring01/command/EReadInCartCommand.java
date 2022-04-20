package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.OrderDao;

public class EReadInCartCommand implements ECommand {

	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		
		OrderDao dao = new OrderDao();
		
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		p_ids =	dao.readPidInCart(uid);
		
		request.setAttribute("p_ids", p_ids);

	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
	}
}
