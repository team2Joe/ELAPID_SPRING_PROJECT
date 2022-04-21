package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminTableDao;

public class EAdminDashboardTableCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		String startdate = request.getParameter("startdate") != null ? request.getParameter("startdate"):"";
		String enddate = request.getParameter("enddate") != null ? request.getParameter("enddate"):"";
		String period = request.getParameter("period") != null ? request.getParameter("period"):"";
		
		String a = "%Y%m%d";
		System.out.println(startdate + enddate + period);

		
		AdminTableDao aDao = sqlSession.getMapper(AdminTableDao.class);
		System.out.println("********"+aDao.customerTrendTable(startdate, enddate, period).size());
		System.out.println("***&&&&&&&&&"+aDao.test(startdate, enddate, period));
		
		
		
		
		request.setAttribute("cttDtos", aDao.customerTrendTable(startdate, enddate, period) != null ? aDao.customerTrendTable(startdate, enddate, period):null);
//		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-mm-dd" );
//		sdf.applyPattern("yyyy-MM-dd");
//
//		System.out.println(cal.getTime());
//		System.out.println(sdf.format(cal.getTime()));
		
		//LogDao lDao = sqlSession.getMapper(LogDao.class);
		
	}

}
