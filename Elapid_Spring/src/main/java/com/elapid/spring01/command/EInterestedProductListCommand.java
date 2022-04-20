package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.ProductDao;


public class EInterestedProductListCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		model.addAttribute("list", dao.interestedProductListDao());
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
	}

}
