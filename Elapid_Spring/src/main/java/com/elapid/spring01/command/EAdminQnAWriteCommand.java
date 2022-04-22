package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminQnADao;

public class EAdminQnAWriteCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {

		session = request.getSession();//u_id Session
		//String ad_id =(String) session.getAttribute("ad_id");
		String ad_id = "uyoung11";
		String anq_title = request.getParameter("anq_title");
		int pq_id = Integer.parseInt(request.getParameter("pq_id"));
		String anq_content = request.getParameter("anq_content");
		System.out.println( pq_id);
		
		AdminQnADao dao = sqlSession.getMapper(AdminQnADao.class);
		AdminQnADao statedao = sqlSession.getMapper(AdminQnADao.class);
		
           
		dao.aQnAWriteDao(anq_title, anq_content, pq_id, ad_id);
		statedao.aQnAStateDao(pq_id);
		
	}

}
