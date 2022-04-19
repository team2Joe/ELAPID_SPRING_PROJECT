package com.elapid.spring01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.CartOrderDao;
import com.elapid.spring01.dao.UserDao;
import com.elapid.spring01.dao.UserDao2;

public class ERegisterCheckCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession,Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		UserDao2 dao2 = new UserDao2();
		
		String uid = request.getParameter("uid");
		String upwd = request.getParameter("upassword");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String ugender = request.getParameter("ugender");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String ubirthdate = birthyear + "-" +birthmonth + "-" + birthday;
		
		dao.userAdd(uid, upwd, uname, uemail, utel, ugender, ubirthdate);
		
		CartOrderDao cdao2 =new CartOrderDao();
		
		cdao2.CartAdd(uid);
		
		
		String addaddress = request.getParameter("jibunAddr");
		String addspecificaddress = request.getParameter("addrDetail");
		String addpostnumber = request.getParameter("zipNo");
		
		int searchresult = dao2.searchAddress(addpostnumber, addaddress);
		
		if(searchresult >= 1) {// 주소북에 같은 주소 있을 시 add_id 받아와서 relation에만 저장 
			dao2.registerAdd(uid, searchresult, addspecificaddress,uname,utel, 1);
		}else { // 주소북에 같은 주소 없을 시 주소북에 주소 저장후 relation 에 상세 주소 저장
			dao2.addressAdd(addpostnumber, addaddress);
			int addid =  dao2.searchAddress(addpostnumber, addaddress);
			dao2.registerAdd(uid,addid, addspecificaddress,uname,utel,1);
			
		}

		
	}
	@Override
	public void execute_session(SqlSession sqlSession,Model model,HttpSession session, HttpServletRequest request) {
	}
}

