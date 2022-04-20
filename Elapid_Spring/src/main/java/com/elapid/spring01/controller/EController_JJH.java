package com.elapid.spring01.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.dao.ProductDao;
import com.elapid.spring01.util.Constant;

@Controller
public class EController_JJH {
	
	// Spring JDBC 방식
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	private ECommand luggageList = null;
	private ECommand luggageFilterList = null;
	private ECommand interestedProductList = null;
	private ECommand detailView = null;
	private ECommand search = null;
	private ECommand middleList = null;
	
	@Autowired
	public void auto(ECommand luggageList, ECommand luggageFilterList,
			ECommand detailView, ECommand search,
			ECommand interestedProductList, ECommand middleList) {
		this.luggageList = luggageList;
		this.luggageFilterList = luggageFilterList;
		this.interestedProductList = interestedProductList;
		this.detailView = detailView;
		this.search = search;
		this.middleList = middleList;
	}
	
	//캐리어 전체 리스트 
	@RequestMapping("luggageList")
	public String luggageList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		luggageList.execute(sqlSession, model);
		
		return "luggageList";
	}
	
	@RequestMapping("/middleList")
	public String middleList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		middleList.execute(sqlSession, model);
		
		return "mainList";
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
	public String detailView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		detailView.execute(sqlSession, model);
		
		return "detailView";
	}
	
	//검색 목록 출력
	@RequestMapping("search")
	public String searchList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		search.execute(sqlSession, model);
		
		return "searchList";
	}	
	
	@RequestMapping("interestedProductList")
	public String interestedProductList(Model model) {
		
		interestedProductList.execute(sqlSession, model);
		
		return "index";
	}
	
	// 상품 등록 페이지
	@RequestMapping("registerProductForm")
	public String registerProductForm() {
		
		return "registerProductForm";
	}
	
	//상품 등록하기
	@RequestMapping("registerProduct")
	public String registerProduct(HttpServletRequest request, Model model) {
		
		return "registerProduct";
	}
	
	
	// 상품 수정 페이지
	@RequestMapping("modifyProductForm")
	public String modifyProductForm(HttpServletRequest request, Model model) {
		
		return "modifyProductForm";
	}
	
	// 상품 수정하기
	@RequestMapping("modifyProduct")
	public String modifyProduct(HttpServletRequest request, Model model) {
		
		return "modifyProduct";
	}
	
	// 상품 삭제하기
	@RequestMapping("deleteProduct")
	public String deleteProduct(HttpServletRequest request, Model model) {
		
		return "deleteProduct";
	}
	
}
