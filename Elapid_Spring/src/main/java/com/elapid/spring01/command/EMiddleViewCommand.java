package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.ProductDao;
import com.elapid.spring01.dao.ProductMiddleListDao;
import com.elapid.spring01.dto.ProductListDto;

public class EMiddleViewCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		ProductMiddleListDao listDao = new ProductMiddleListDao();
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String ctg_middle = request.getParameter("ctg_middle");
		
		// 중분류 where 쿼리문
		int count = dao.productCountDao("where ctg_middle = '" + ctg_middle + "'");
		
		String tempStart = request.getParameter("page");
		
		int startPage = 0;
		int onePageCount = 3;
		
		count = (int)Math.ceil((double)count/(double)onePageCount);
		
		if(tempStart != null) {
			startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
		}
		
		ArrayList<ProductListDto> dtos = listDao.middleListDao(ctg_middle, startPage, onePageCount);

		model.addAttribute("count", count);
		model.addAttribute("list", dtos);
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
	}

}
