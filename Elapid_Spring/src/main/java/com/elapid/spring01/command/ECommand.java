package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ECommand {
	
	public void execute(SqlSession sqlSession,Model model);
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request);
	
}
