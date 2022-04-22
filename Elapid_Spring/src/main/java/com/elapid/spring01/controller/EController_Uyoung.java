package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;

@Controller
public class EController_Uyoung {

	private HttpSession session;

	ECommand command = null;
	private ECommand addCartCommand = null;
	private ECommand cartViewCommand = null;
	private ECommand cartDeleteCommand = null;
	private ECommand adminQnAListCommand = null;
	private ECommand adminQnAContentCommand = null;
	private ECommand adminQnAWriteCommand = null;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public void CartCommand(ECommand addCart, ECommand cartView, ECommand cartDelete,
							ECommand aQnAList, ECommand aQnAWrite, ECommand aQnAContent
							) {
		/* Cart */
		this.addCartCommand = addCart;
		this.cartViewCommand = cartView;
		this.cartDeleteCommand = cartDelete;
		/* AQnA */
		this.adminQnAListCommand = aQnAList;
		this.adminQnAContentCommand = aQnAContent;
		this.adminQnAWriteCommand = aQnAWrite;
		
	}
	

	/* CartAdd */
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request, Model model) {
		//System.out.println("addCart()");
		addCartCommand.execute_session(sqlSession, model, session, request);
	
		return "cartLink";// page유지
	}

	/* CartView */
	@RequestMapping("/cartView")
	public String cart_View(Model model, HttpServletRequest request) {
		//System.out.println("cart_View()");
		cartViewCommand.execute_session(sqlSession, model, session, request);
		
		return "userCartView";
	}
	
	
	/* CartDelete */
	@RequestMapping("/cartDelete")
	public String cartDelete(HttpServletRequest request, Model model) {
		//System.out.println("cartDelete()");
		cartDeleteCommand.execute_session(sqlSession, model, session, request);
		
		return "redirect:cartView";
	}

	
	/* Admin QnA List*/
	@RequestMapping("/aQnAList")
	public String aQnaList(HttpServletRequest request, Model model) {
		System.out.println("aQnaList()");
		adminQnAListCommand.execute_session(sqlSession, model, session, request);
		
		return "aQnAList";
	}
	
	
	/* Admin QnA Content */
	@RequestMapping("/aQnAContent")
	public String aQnAContent(HttpServletRequest request, Model model) {
		System.out.println("aQnAContent()");
		adminQnAContentCommand.execute_session(sqlSession, model, session, request);
		
		return "aQnAListDetail";
	}
	
	
	/*Admin QnA WriteView*/
	@RequestMapping("/aQnAWriteView")
	public String aQnAWriteView(HttpServletRequest request, Model model) {
		int pq_id = Integer.parseInt(request.getParameter("pq_id"));
		System.out.println("aQnAWriteView()" + pq_id);
		model.addAttribute("write" , pq_id);
		
		return "aQnAWrite";
	}
	
	
	/* Admin QnA Write */
	@RequestMapping("/aQnAWrite")
	public String aQnAWrtie(HttpServletRequest request, Model model) {
		//int pq_id = Integer.parseInt(request.getParameter("pq_id"));
		System.out.println("aQnAWrite()");
		
		adminQnAWriteCommand.execute_session(sqlSession, model, session, request);
		
		return "redirect:aQnAList";
	}
	
	
	
	
	
	
	
	
	
	
	
}
