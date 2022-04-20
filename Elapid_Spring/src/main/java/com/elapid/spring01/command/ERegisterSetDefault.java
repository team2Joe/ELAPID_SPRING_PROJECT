package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao2;

public class ERegisterSetDefault implements ECommand {

	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		session = request.getSession();
		
		UserDao2 dao = new UserDao2();
		String uid = (String) session.getAttribute("uid");
		int add_id = Integer.parseInt(request.getParameter("add_id")); 
		
		
		dao.registerSetNoDefault(uid);
		dao.registerSetDefault(uid, add_id);
	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
	}

}
