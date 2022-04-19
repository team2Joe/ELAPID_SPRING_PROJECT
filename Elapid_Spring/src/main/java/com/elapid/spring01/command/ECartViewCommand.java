package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserCartDao;

public class ECartViewCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub

	session = request.getSession();//u_id Session
	String u_id =(String) session.getAttribute("uid");
	 
	UserCartDao dao = sqlSession.getMapper(UserCartDao.class);
	model.addAttribute("cart_View", dao.CartViewDao(u_id));
	
	}
}
