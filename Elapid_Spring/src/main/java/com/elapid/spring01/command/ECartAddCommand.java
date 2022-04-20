package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserCartDao;

public class ECartAddCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, 
								HttpServletRequest request) {
		
		session = request.getSession();//u_id Session
		String u_id =(String) session.getAttribute("uid");
		int p_id =  Integer.parseInt(request.getParameter("p_id"));
		
		UserCartDao dao = sqlSession.getMapper(UserCartDao.class);
		dao.AddCartDao(p_id ,u_id);
		//String u_id = "elapid01";
		
	}

		
	

}
