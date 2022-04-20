package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao;
import com.elapid.spring01.dao.UserLogDao;
import com.elapid.spring01.dto.UserDto;


public class ELoginCheckCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession,Model model) {
		
	}
	@Override
	public void execute_session(SqlSession sqlSession, Model model,HttpSession session,HttpServletRequest request) {

		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		session = request.getSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);
		String uid = "";
		

		UserLogDao lDao = new UserLogDao();
		
		
		
		uid = request.getParameter("uid");
		UserDto dto = dao.profileView(uid);
		String upassword = request.getParameter("upassword");
		int result = dao.loginCheck(uid, upassword);
		
		if(result == 1 ) {
			session.setAttribute("uid",uid);
			session.setAttribute("upoint",dto.getU_point());
			request.setAttribute("loginviewparam", "redirect:main");
			
			String name = dto.getU_name();
			session.setAttribute("comment", name + "님 환영합니다.");

			
			lDao.userLoginLogAdd(uid);
		}else{
			request.setAttribute("loginviewparam", "loginForm");
		}
		
	}

}
