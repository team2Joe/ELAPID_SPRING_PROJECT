package com.elapid.spring01.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao;

public class EProfileDeleteCommand implements ECommand {


	@Override
	public void execute(SqlSession sqlSession,Model model) {
		
	}
	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.profileDelete(uid);
		session.invalidate();
	}

}
