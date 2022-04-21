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
		
		dao.visitorCount(ip, funnel);
		
//		if(dao.returnLatestDateTime(ip) != null) {
//		
//			DatesDto datesDto = dao.returnLatestDateTime(ip);
//			Long date = Long.parseLong(datesDto.getDate());
//			Long nowDate = Long.parseLong(datesDto.getNowdate());
//			dao.visitorCount(ip, nowDate-date>=6000 ? funnel : "revisit" );
//		}else {
//			dao.visitorCount(ip, funnel);
//		}
//		
		System.out.println("*************"+ip);
		
		
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		
		
		
	}

}
