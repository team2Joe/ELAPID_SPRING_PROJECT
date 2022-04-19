package com.elapid.spring01.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductListDto;

public class EInterestedProductListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.interestedProductList();
		
		request.setAttribute("list", dtos);

	}

	@Override
	public void execute(SqlSession sqlSession, HttpServletResponse response) {
		
		
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
