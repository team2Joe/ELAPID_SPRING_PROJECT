package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao;
import com.elapid.spring01.dto.UserDto;

public class EMyPageCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession,Model model) {
		
	}
	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		
		String uid = (String)session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		UserDto dto = new UserDto();
		
		dto = dao.profileView(uid);
		
		request.setAttribute("profiledto", dto);
	}

}
