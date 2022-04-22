package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminQnADao;

public class EAdminQnAContentCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int pq_id = Integer.parseInt(request.getParameter("pq_id"));

		AdminQnADao dao = sqlSession.getMapper(AdminQnADao.class);
		AdminQnADao dao1 = sqlSession.getMapper(AdminQnADao.class);
		
		model.addAttribute("aQnAContent", dao.aQnAContentDao(pq_id));
		model.addAttribute("QnAContent", dao1.QnAContentDao(pq_id));
		
		
		
	}

}
