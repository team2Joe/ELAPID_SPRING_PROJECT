package com.elapid.spring01.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.ProductDao;

public class ELuggageListCommand implements ECommand {
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
				
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		// 캐리어 전체 행 갯수 반환 카운트 메서드
		int count = dao.productCountDao("where ctg_main = 'luggage'");
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		// luggageList.jsp 페이지버튼에서 get으로 받은 page값
		String tempStart = request.getParameter("page");
		
		int startPage = 0; // 첫페이지 받아오기
		int onePageCount = 3; // 페이지 하나당 보여줄 상품 갯수
		
		// 페이지 수 저장
		// Math.ceil() : 입력받은 파라미터 값보다 크거나 같은 가장 작은 정수값을 double형태로 반환해주는 메서드
		// 더블형태로 반환받기 때문에 int로 다운캐스팅
		count = (int)Math.ceil((double)count/(double)onePageCount);
		
		if(tempStart != null) { // 처음에는 실행하지 않음
								// 2번째 페이지 부터 onePageCount단위로 startPage가 변경됨
			startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
		}

		model.addAttribute("count", count);
		model.addAttribute("list", dao.luggageListDao(startPage, onePageCount));
		
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
	}

}
