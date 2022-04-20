package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.QnaDao;


public class EQuestionModifyCommand implements ECommand {
	

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub

		
		
	
		session = request.getSession();
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		String qc_name =request.getParameter("qc_name");
//		String u_id = (String) session.getAttribute("uid");
		int pq_id =Integer.parseInt(request.getParameter("pq_id"));
		String pq_title = request.getParameter("pq_title");
		String pq_content= request.getParameter("pq_content");
	
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		//model.addAttribute("questionModify", dao.modifyDao());
		dao.modifyDao(qc_name, pq_title, pq_content, pq_id);
		
		
	}
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}
}
