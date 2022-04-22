package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminQnADao;

public class EAdminQnAListCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		
//		int pq_id = Integer.parseInt(request.getParameter("pq_id"));
//		String qc_name = request.getParameter("qc_name");
//		String u_id = (String) session.getAttribute("uid");
//		String pq_title = request.getParameter("pc_title");
//		String pq_content = request.getParameter("pc_content");
		
		AdminQnADao dao = sqlSession.getMapper(AdminQnADao.class);
		model.addAttribute("aQnAList", dao.aQnAListDao());
		
		
		
		
		
		
		
	}

}
