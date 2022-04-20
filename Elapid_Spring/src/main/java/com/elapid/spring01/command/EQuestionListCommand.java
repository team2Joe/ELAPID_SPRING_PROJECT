package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.QnaDao;


public class EQuestionListCommand implements ECommand {
	
	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		session = request.getSession();
		String u_id = (String) session.getAttribute("uid");
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		model.addAttribute("questionList", dao.listDao(u_id));
		System.out.println(dao.listDao(u_id));
		
	}
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}

}
