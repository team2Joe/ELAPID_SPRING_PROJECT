package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.QnaDao;



public class EQuestionDeleteCommand implements ECommand {

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub
	

		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("pq_id")));

	}

		@Override
		public void execute(SqlSession sqlSession, Model model) {

			
		}

}
