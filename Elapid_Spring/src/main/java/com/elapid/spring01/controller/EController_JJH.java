package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.dao.ProductDao;

@Controller
public class EController_JJH {
	
	@Autowired
	SqlSession sqlSession;
	
	private ECommand luggageList = null;
	private ECommand luggageFilterList = null;
//	private ECommand interestedProductList = null;
//	private ECommand detailView = null;
//	private ECommand search = null;
	
	@Autowired
	public void auto(ECommand luggageList, ECommand luggageFilterList) {
		this.luggageList = luggageList;
		this.luggageFilterList = luggageFilterList;
//		this.interestedProductList = interestedProductList;
//		this.detailView = detailView;
//		this.search = search;

	}
	
	//메인 화면
//	@RequestMapping("main")
//	public String main() {
//		
//		return "index";
//	}
	
	//캐리어 전체 리스트 
	@RequestMapping("luggageList")
	public String luggageList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		luggageList.execute(sqlSession, model);
		
		return "luggageList";
	}
	
	// 캐리어 전용 필터
	@RequestMapping("luggageFilterList")
	public String luggageFilterList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		luggageFilterList.execute(sqlSession, model);
		
		return "luggageFilterList";
	}
	
	//제품 상세 페이지
	@RequestMapping("detailView")
	public String detailView() {
		
		return "detailView";
	}
	
	//검색 목록 출력
	@RequestMapping("search")
	public String searchList() {
		
		return "searchList";
	}	
	
	@RequestMapping("interestedProductList")
	public String interestedProductList() {
		
		
		return "index";
	}
	
}
