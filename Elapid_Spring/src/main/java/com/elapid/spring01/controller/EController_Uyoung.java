package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECartAddCommand;
import com.elapid.spring01.command.ECommand;

@Controller
public class EController_Uyoung {

	private HttpSession session;

	ECommand command = null;
	private ECommand addCartCommand = null;
	private ECommand cartViewCommand = null;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public void CartCommand(ECommand addCart, ECommand cartView) {
		this.addCartCommand = addCart;
		this.cartViewCommand = cartView;
	}
	

	/* CartAdd */
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request, Model model) {
		
		System.out.println("addCart()");
		
		command = new ECartAddCommand();
		command.execute_session(sqlSession, model, session, request);
		 
		//addCartCommand.execute_session(sqlSession, model, session, request);
		return "index";// page유지
	}

	/* CartView */
	@RequestMapping("/cartView")
	public String cart_View(Model model, HttpSession session) {

		System.out.println("cart_View");

		cartViewCommand.execute_session(sqlSession, model, session, null);
		return "userCartView";
	}

}
