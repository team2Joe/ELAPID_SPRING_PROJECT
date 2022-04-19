package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class EGoogleLoginCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession,Model model) {
		// TODO Auto-generated method stub

		
	}
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		session = request.getSession();
		
		String id = request.getParameter("gemail");
//		String img = request.getParameter("gimg");
		String name = request.getParameter("gname");
//		String email = request.getParameter("gemail");
		
		
		session.setAttribute("uid", id);
		session.setAttribute("comment", name+"님 환영합니다.");
		session.setAttribute("gresult", "1");
	}

}
