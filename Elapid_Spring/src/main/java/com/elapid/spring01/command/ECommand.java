package com.elapid.spring01.command;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletResponse;
>>>>>>> e858782f5459166e842ae976896e1845b452044b
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ECommand {
	
	public void execute(SqlSession sqlSession,Model model);
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request);
	
}
