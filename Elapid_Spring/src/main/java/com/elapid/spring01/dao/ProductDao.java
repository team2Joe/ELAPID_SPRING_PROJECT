package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.ProductDetailDto;
import com.elapid.spring01.dto.ProductListDto;

public interface ProductDao {
	
	// 상품 갯수 반환
	public int productCountDao(String value);
	
	// 캐리어 전체 리스트
	public ArrayList<ProductListDto> luggageListDao(int startPage, int onePageCount);
	
	// 캐리어 필터링 된 리스트
	public ArrayList<ProductListDto> luggageFilterListDao(String[] ctg_middle, String[] ps_color, String[] p_mainf,
			int startPage, int onePageCount);
	
	// 조회수 많은 상품 리스트
	public ArrayList<ProductListDto> interestedProductListDao();
	
	// 조회수 증가 메서드
	public void increaseDetailView(String p_id);
	
	// 검색 기능
	public ArrayList<ProductListDto> searchDao(String search, String category);
	
	// 상세 페이지
	public ProductDetailDto detailViewDao(String p_id);
	
}
