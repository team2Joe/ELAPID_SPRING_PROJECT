package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.RegisterDao;


public class EIdCheckCommand implements ECommand {


	@Override
	public void execute(SqlSession sqlSession,Model model) {
		
	}
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		session = request.getSession();
		
		RegisterDao dao = new RegisterDao();
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String comment = "";
		int result = 0;
		result = dao.idCheck(uid);
		
		if(result >= 1) {
			comment = "중복된 아이디 입니다.";
		}else {
			comment = "사용 가능한 아이디입니다.";
		}
		
		session.setAttribute("reguid",uid);
		session.setAttribute("uname",uname);
		session.setAttribute("uemail",uemail);
		session.setAttribute("utel",utel);
		
		session.setAttribute("idcheckresult",result);
		session.setAttribute("idcheckcomment", comment);	
	}
}
