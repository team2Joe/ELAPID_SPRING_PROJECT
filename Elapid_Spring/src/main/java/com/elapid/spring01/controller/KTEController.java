package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;

@Controller
public class KTEController {
	

	ECommand ELoginCheckCommand = null ;
	
	
	@Autowired
	public void Auto(ECommand ELoginCheck) {
		
	}
	
	//로그인 폼
	@RequestMapping("loginForm")
	public String loginForm() {
		
		return "loginForm";
	}
	
	//로그인 체크
	@RequestMapping("loginCheck")
	public String loginCheck(HttpServletRequest request) {
		
		return (String)request.getAttribute("loginviewparam");
	}
	
	//구글 로그인
	@RequestMapping("googleLogin")
	public String googleLogin() {
		
		return "redirect:main";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout() {
		
		return "redirect:loginForm";
	}
	
	//구글 로그아웃
	@RequestMapping("googleLogout")
	public String googleLogout() {
		
		return "redirect:loginForm";
	}
	
	//회원가입 폼
	@RequestMapping("registerForm")
	public String registerForm() {
		
		return "registerForm";
	}
	
	//아이디 중복 체크
	@RequestMapping("idCheck")
	public String idCheck() {
		
		return "redirect:registerForm";
	}
	
	//회원가입 양식 체크 후 회원가입
	@RequestMapping("registerCheck")
	public String registerCheck() {
		
		return "redirect:loginForm";
	}
	
	//마이페이지 화면
	@RequestMapping("myPage")
	public String myPage() {
		
		return "myPage";
	}
	
	//내 정보 보기
	@RequestMapping("profileView")
	public String profileView() {
		
		return "profileView";
	}
	
	//내 정보 수정
	@RequestMapping("profileModify")
	public String profileModify() {
		
		return "redirect:profileView";
	}
	
	//회원 탈퇴
	@RequestMapping("profileDelete")
	public String profileDelete() {
		
		return "redirect:main";
	}
	
	//주소 추가 화면
	@RequestMapping("registerAddForm")
	public String registerAddForm() {
		
		return "registerAddForm";
	}
	
	//주소 추가
	@RequestMapping("registerAdd")
	public String registerAdd() {
		
		return "redirect:addressBookView";
	}
	
	//주소 삭제
	@RequestMapping("registerDelete")
	public String registerDelete() {
		
		return "redirect:addressBookView";
	}
	
	//기본 주소지 설정
	@RequestMapping("registerSetDefault")
	public String registerSetDefault() {
		
		return "redirect:addressBookView";
	}
	
	//회원 주문하기 화면
	@RequestMapping("userOrderForm")
	public String userOrderForm() {
		
		return "userOrderForm";
	}
	
	//장바구니 상품들 읽어오기
	@RequestMapping("readInCart")
	public String readInCart() {
		
		return "redirect:userOrderForm";
	}
	
	//장바구니에서 선택상품 가져와서 형변환
	@RequestMapping("selectedReadInCart")
	public String selectedReadInCart() {
		
		return "redirect:userOrderForm";
	}
	
	//회원 주문하기 
	@RequestMapping("userOrder")
	public String userOrder() {
		
		return "userOrderCompletePage";
	}
	
	//유저 주문내역 
	@RequestMapping("userOrderHistory")
	public String userOrderHistory() {
		
		return "userOrderHistory";
	}
}
