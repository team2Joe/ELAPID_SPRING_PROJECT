package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.ProductDao;


public class ESearchCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String search = request.getParameter("search");
		String category = request.getParameter("category");		
		
		model.addAttribute("list", dao.searchDao(category, search.trim()));
	}
	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {

	}

}
