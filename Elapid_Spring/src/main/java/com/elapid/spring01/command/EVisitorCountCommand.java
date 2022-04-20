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
		String funnel = request.getParameter("funnel") != null ? request.getParameter("funnel"):"homepage";
		
		LogDao dao = sqlSession.getMapper(LogDao.class);
		
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		
		DatesDto datesDto = dao.returnLatestDateTime(ip);
		int date = Integer.parseInt(datesDto.getDate());
		int nowDate = Integer.parseInt(datesDto.getNowdate());
		
		if(nowDate - date >= 6000) {
			dao.visitorCount(ip,funnel);
		}
		
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		
		
		
	}

}
