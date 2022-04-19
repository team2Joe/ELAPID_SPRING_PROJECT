package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.dao.UserCartDao;


@Controller
public class EController_Uyoung {

	ECommand command = null;	
	private ECommand addCartCommand =null;
	private HttpSession session;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Autowired
	public void CartCommand(ECommand addCart) {
		this.addCartCommand = addCart;
	}
	
	/*Test*/
	@RequestMapping("cart/{p_id}")
	public String addCart(){
		
		return"addCart";
	}
	
	
	/* CartAdd */
	@RequestMapping("/addCart")
	 public String addCart(SqlSession sqlSession,HttpServletRequest request, Model model) {
		System.out.println("addCart()");
		addCartCommand.execute_session(sqlSession, model,session, request);
		return "";//page유지
	}

	/* CartView */
	@RequestMapping("/cartView")
	public String cartView(SqlSession sqlSession, Model model, HttpSession session) {
		
		System.out.println("cartView");
		
		return "";
	}
















}
