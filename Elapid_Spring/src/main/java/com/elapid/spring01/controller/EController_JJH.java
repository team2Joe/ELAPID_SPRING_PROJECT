package com.elapid.spring01.controller;

import java.net.http.HttpHeaders;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elapid.spring01.command.ECommand;
import com.elapid.spring01.dao.ProductImageDao;
import com.elapid.spring01.util.Constant;

@Controller
public class EController_JJH {
	
	// Spring JDBC 방식
	private JdbcTemplate template;
	
	private ProductImageDao dao;
	
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
	private ECommand registerProduct = null;
	
	@Autowired
	public void auto(ECommand luggageList, ECommand luggageFilterList,
			ECommand detailView, ECommand search,
			ECommand interestedProductList, ECommand middleList,
			ECommand registerProduct) {
		this.luggageList = luggageList;
		this.luggageFilterList = luggageFilterList;
		this.interestedProductList = interestedProductList;
		this.detailView = detailView;
		this.search = search;
		this.middleList = middleList;
		this.registerProduct = registerProduct;
	}
	
	// 캐리어 전체 리스트 
	@RequestMapping("luggageList")
	public String luggageList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		luggageList.execute(sqlSession, model);
		
		return "luggageList";
	}
	
	// 캐리어 필터링 검색
	@RequestMapping("luggageFilterList")
	public String luggageFilterList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		luggageFilterList.execute(sqlSession, model);
		
		return "luggageFilterList";
	}
	
	// 제품 상세 페이지
	@RequestMapping("detailView")
	public String detailView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		detailView.execute(sqlSession, model);
		
		return "detailView";
	}
	
	// 검색 목록 출력
	@RequestMapping("search")
	public String searchList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		search.execute(sqlSession, model);
		
		return "searchList";
	}	
	
	// 조회수 많은 순 페이지
	@RequestMapping("interestedProductList")
	public String interestedProductList(Model model) {
		
		interestedProductList.execute(sqlSession, model);
		
		return "index";
	}
	
	
	@RequestMapping("/middleList")
	public String middleList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		middleList.execute(sqlSession, model);
		
		return "mainList";
	}
	
	// 상품 등록 페이지
	@RequestMapping("registerProductForm")
	public String registerProductForm() {
		
		return "registerProductForm";
	}
	
	//상품 등록하기
	@RequestMapping("registerProduct")
	public String registerProduct(HttpServletRequest request, Model model) {
		
		
		
		model.addAttribute("request", request);
		registerProduct.execute(sqlSession, model);	
		
		return "index";
	}
	
	// blob 이미지 가져오기
	@RequestMapping(value="/getByteImage")
	public ResponseEntity<byte[]> getByteImage() {
		
	    Map<String, Object> map = dao.getByteImage();
	       byte[] imageContent = (byte[]) map.get("img_thum");
	       final org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	       headers.setContentType(MediaType.IMAGE_PNG);
	       return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
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
