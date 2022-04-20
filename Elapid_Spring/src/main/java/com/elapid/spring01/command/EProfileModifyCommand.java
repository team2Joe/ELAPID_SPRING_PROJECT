package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao;

public class EProfileModifyCommand implements ECommand {

	
	@Override
	public void execute(SqlSession sqlSession,Model model) {
		
	}
	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		String uid = (String)session.getAttribute("uid");
		String upwd = request.getParameter("upassword");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String ugender = request.getParameter("ugender");
		
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String ubirthdate = birthyear + "-" +birthmonth + "-" + birthday;
		
		System.out.println(uid +"*********************"+ ubirthdate );
		
		dao.profileModify(uemail, upwd, utel, ugender, ubirthdate,uid);
		
	}

}
