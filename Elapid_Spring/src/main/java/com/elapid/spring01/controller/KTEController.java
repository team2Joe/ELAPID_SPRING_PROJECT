package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.EAddressBookViewCommand;
import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.command.EReadInCartCommand;
import com.elapid.spring01.command.ERegisterAddCommand;
import com.elapid.spring01.command.ERegisterDeleteCommand;
import com.elapid.spring01.command.ERegisterSetDefault;
import com.elapid.spring01.command.ESelectedReadInCartCommand;
import com.elapid.spring01.command.EUserOrderCommand;
import com.elapid.spring01.command.EUserOrderFormCommand;
import com.elapid.spring01.command.EUserOrderHistoryCommand;

@Controller
public class KTEController {
	
	private HttpSession session;
	
	ECommand command = null;
	private ECommand eLoginCheckCommand = null ;
	private ECommand eGoogleLoginCommand = null ;
	private ECommand eIdCheckCommand = null ;
	private ECommand eRegisterCheckCommand = null ;
	private ECommand eMyPageCommand = null ;
	private ECommand eProfileModifyCommand = null ;
	private ECommand eProfileDeleteCommand = null ;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void Auto(ECommand eLoginCheck, ECommand eGoogleLogin, ECommand eIdCheck, ECommand eRegisterCheck,ECommand eMyPage,ECommand eProfileModify,ECommand eProfileDelete) {
		this.eLoginCheckCommand = eLoginCheck;
		this.eGoogleLoginCommand = eGoogleLogin;
		this.eIdCheckCommand= eIdCheck;
		this.eRegisterCheckCommand= eRegisterCheck;
		this.eMyPageCommand= eMyPage;
		this.eProfileModifyCommand= eProfileModify;
		this.eProfileDeleteCommand= eProfileDelete;
	}
	
	//로그인 폼
	@RequestMapping("loginForm")
	public String loginForm() {
		
		return "loginForm";
	}
	
	//로그인 체크
	@RequestMapping("loginCheck")
	public String loginCheck(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		eLoginCheckCommand.execute_session(sqlSession,model,session, request);
		
		return (String)request.getAttribute("loginviewparam");
	}
	
	//구글 로그인
	@RequestMapping("googleLogin")
	public String googleLogin(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		eGoogleLoginCommand.execute_session(sqlSession, model, session, request);
		
		return "redirect:main";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		session = request.getSession();
		session.invalidate();
		
		return "redirect:loginForm";
	}
	
	//구글 로그아웃
	@RequestMapping("googleLogout")
	public String googleLogout(HttpServletRequest request) {
		session = request.getSession();
		session.invalidate();
		
		return "redirect:loginForm";
	}
	
	//회원가입 폼
	@RequestMapping("registerForm")
	public String registerForm() {
		
		return "registerForm";
	}
	
	//회원가입 폼
	@RequestMapping("jusoPopup")
	public String jusoPopup() {
		
		return "jusoPopup";
	}
	
	//아이디 중복 체크
	@RequestMapping("idCheck")
	public String idCheck(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		eIdCheckCommand.execute_session(sqlSession, model, session, request);
		
		return "redirect:registerForm";
	}
	
	//회원가입 양식 체크 후 회원가입
	@RequestMapping("registerCheck")
	public String registerCheck(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		eRegisterCheckCommand.execute(sqlSession, model);
		
		return "redirect:loginForm";
	}
	
	//마이페이지 화면
	@RequestMapping("myPage")
	public String myPage(HttpServletRequest request,Model model) {
		eMyPageCommand.execute_session(sqlSession, model, session, request);
		return "myPage";
	}
	
	//내 정보 보기
	@RequestMapping("profileView")
	public String profileView(HttpServletRequest request,Model model) {
		eMyPageCommand.execute_session(sqlSession, model, session, request);
		return "profileView";
	}
	
	//내 정보 수정
	@RequestMapping("profileModify")
	public String profileModify(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		eProfileModifyCommand.execute_session(sqlSession, model, session, request);
		return "redirect:profileView";
	}
	
	//회원 탈퇴
	@RequestMapping("profileDelete")
	public String profileDelete(HttpServletRequest request,Model model) {
		eProfileDeleteCommand.execute_session(sqlSession, model, session, request);
		return "redirect:main";
	}
	
	//주소록 보기
	@RequestMapping("addressBookView")
	public String addressBookView(HttpServletRequest request) {
		command = new EAddressBookViewCommand();
		command.execute_session(sqlSession, null, session,request);
		return "addressBookView";
	}
	
	//주소 추가 화면
	@RequestMapping("registerAddForm")
	public String registerAddForm() {
		return "registerAddForm";
	}
	
	//주소 추가
	@RequestMapping("registerAdd")
	public String registerAdd(HttpServletRequest request,Model model) {
		command = new ERegisterAddCommand();
		command.execute_session(sqlSession, model, session, request);
		
		return "redirect:addressBookView";
	}
	
	//주소 삭제
	@RequestMapping("registerDelete")
	public String registerDelete(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command = new ERegisterDeleteCommand();
		command.execute_session(sqlSession, model, session, request);
		
		return "redirect:addressBookView";
	}
	
	//기본 주소지 설정
	@RequestMapping("registerSetDefault")
	public String registerSetDefault(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command = new ERegisterSetDefault();
		command.execute_session(sqlSession, model, session, request);
		
		return "redirect:addressBookView";
	}
	
	//회원 주문하기 화면
	@RequestMapping("userOrderForm")
	public String userOrderForm(HttpServletRequest request,Model model) {
		command = new EUserOrderFormCommand();
		command.execute_session(sqlSession, model, session, request);
		
		return "userOrderForm";
	}
	
	//장바구니 상품들 읽어오기
	@RequestMapping("readInCart")
	public String readInCart(HttpServletRequest request) {
		command = new EReadInCartCommand();
		command.execute_session(sqlSession, null, session, request);
		
		return "redirect:userOrderForm";
	}
	
	//장바구니에서 선택상품 가져와서 형변환
	@RequestMapping("selectedReadInCart")
	public String selectedReadInCart(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command = new ESelectedReadInCartCommand();
		command.execute_session(sqlSession, model, session, request);
		return (String)request.getAttribute("selectedpage");
	}
	
	//회원 주문하기 
	@RequestMapping("userOrder")
	public String userOrder(HttpServletRequest request,Model model) {
		command = new EUserOrderCommand();
		command.execute_session(sqlSession, model, session, request);
		return "userOrderCompletePage";
	}
	
	//유저 주문내역 
	@RequestMapping("userOrderHistory")
	public String userOrderHistory(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command = new EUserOrderHistoryCommand();
		command.execute_session(sqlSession, model, session, request);
		
		return "userOrderHistory";
	}
}
