package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.ProductDetailDto;
import com.elapid.spring01.dto.ProductListDto;

public interface ProductDao {
	
	// 상품 갯수 반환
	public int productCountDao(String value);
	
	public ArrayList<ProductListDto> luggageListDao(int startPage, int onePageCount);
	
	public ArrayList<ProductListDto> luggageFilterListDao(String[] ctg_middle, String[] ps_color, String[] p_mainf, int startPage, int onePageCount);
	
	public ArrayList<ProductListDto> interestedProductListDao();
	
	public ArrayList<ProductListDto> searchDao(String search, String category);
	
	public ProductDetailDto detailViewDao(String p_id);
	
	// 조회수 증가 메서드
	public void increaseDetailView(String p_id);
}
