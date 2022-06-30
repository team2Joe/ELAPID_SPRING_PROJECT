package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.EQuestionListCommand;
import com.elapid.spring01.command.EQuestionWriteCommand;
import com.elapid.spring01.command.EQuestionModifyCommand;
import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.command.EQuestionDeleteCommand;

@Controller
public class AhController {

	HttpSession session;
	@Autowired 
	private SqlSession sqlSession;
	
	ECommand command = null;

	//메인 화면
//	@RequestMapping("main")
//	public String main() {
//		
//		return "index";
//	}
	
	
	//문의 목록
	@RequestMapping("questionList")
	public String questionList(Model model) {
		command = new EQuestionListCommand();
		command.execute(sqlSession, model);	
		
		return "questionList";
	}
	
	//문의 내용 보기
	@RequestMapping("questionContentView")
	public String questionContentView(HttpServletRequest request, Model model) {
		command = new EQuestionListCommand();
		command.execute_session(sqlSession, model, session, request);	
		return "questionContent";
	}
	
	//문의 작성 폼
	@RequestMapping("questionWriteForm")
	public String questionWriteForm(HttpServletRequest request, Model model) {
		
		return "questionWrite";
	}
	
	//문의 작성
	@RequestMapping("questionWrite")
	public String questionWrite(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new EQuestionWriteCommand();
		command.execute_session(sqlSession, model, session, request);
		
		return "redirect:questionList";
	}
	
	//문의 수정
	@RequestMapping("questionModify")
	public String questionModify(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			command = new EQuestionModifyCommand();
			command.execute_session(sqlSession, model, session, request);	
			
		
		return "redirect:questionList";
	}
	
	//문의 삭제
	@RequestMapping("questionDelete")
	public String questionDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new EQuestionDeleteCommand();
		command.execute_session(sqlSession, model, session, request);	
		
		return "redirect:questionList";
	}
	
	
}
