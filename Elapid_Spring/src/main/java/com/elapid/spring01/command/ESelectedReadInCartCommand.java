package com.elapid.spring01.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.CartOrderDao;
import com.elapid.spring01.dao.OrderDao;

public class ESelectedReadInCartCommand implements ECommand {


	
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		session = request.getSession();
		String[] strcd_ids = request.getParameterValues("cartchoice");
		
		ArrayList<Integer> cd_ids = new ArrayList<Integer>();
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		
		// 선택된 카트디테일 번호를 
		try {
			for (int i = 0 ; i < strcd_ids.length ; i++) {
				cd_ids.add(Integer.parseInt(strcd_ids[i]));
			}
			request.setAttribute("selctedpage", "redirect:userOrderForm");
		}catch(Exception e) {
			request.setAttribute("selctedpage", "redirect:userCartView?noselect=1");
			return;
			//response.sendRedirect("userCartView.do?noselect=1");
		}
		
		CartOrderDao cDao = new CartOrderDao();
		
		p_ids = cDao.searchBycdids(cd_ids);
		
		request.setAttribute("p_ids",p_ids);
		request.setAttribute("cd_ids",cd_ids);


	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}
}
