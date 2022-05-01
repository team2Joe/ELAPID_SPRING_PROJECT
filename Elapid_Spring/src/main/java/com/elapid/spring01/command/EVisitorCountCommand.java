package com.elapid.spring01.command;

import java.security.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.elapid.spring01.dao.LogDao;
import com.elapid.spring01.dto.DatesDto;

public class EVisitorCountCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// 유입 경로 없을 때 예외처리, 디폴트로 "homepage"
		String funnel = request.getParameter("funnel") != null ? request.getParameter("funnel"):"homepage";
		
		LogDao dao = sqlSession.getMapper(LogDao.class);
		
		
		// ip 받아오기
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		
		// 방문자수 카운트(유입경로, ip 체크 후 순방문자수 카운트)
		dao.visitorCount(ip, funnel);
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
	
	}

}
