package com.elapid.spring01.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.UserDao2;
import com.elapid.spring01.dto.RegisterJoinDto;

public class EAddressBookViewCommand implements ECommand {

	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		UserDao2 dao = new UserDao2();
		ArrayList<RegisterJoinDto> dtos = new ArrayList<RegisterJoinDto>();
		String uid = (String) session.getAttribute("uid"); 
		
		dtos = dao.searchRegisterForUser(uid);
		
//		RegisterJoinDto dto = new RegisterJoinDto();
//		
//		dto = dtos.get(1);
//		System.out.println("*********");
//		System.out.println(dto.getReg_name());
		
		request.setAttribute("registerdtos", dtos);
	}

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		
	}

}
