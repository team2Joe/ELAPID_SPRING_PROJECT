package com.elapid.spring01.dao;

import java.util.Map;

import com.elapid.spring01.dto.PidDto;
import com.elapid.spring01.dto.ProductDetailDto;

public interface AdminProductDao {
	
	// 상품등록
	public void registerProduct(String p_name, int p_stock, int p_price, int p_size,
			String p_mainf, String ps_color, String ps_material, int ps_size, int ps_height, 
			int ps_depth, int ps_width, int ps_volume, int ps_weight,
			 String ctg_main, String ctg_middle, String ctg_sub,
			String img_thum, String img_01, String img_02, String img_03,
			String img_04, String img_05, String img_06);
	
	//상품id number 반환
	public PidDto selectPidNum();
	
	// 상품과 카테고리, 이미지, 스펙 사이의
	// 릴레이션 외래키에 해당 p_id number 넣어주기
	public void insertRelationProductForeignKey(int selectPidNum, int selectPidNum02,
			 int selectPidNum03, int selectPidNum04, int selectPidNum05, int selectPidNum06);
	
	// 상품수정 페이지
	public ProductDetailDto modifyProductView();
	
	// 상품 수정하기
	public void modifyProduct();
	
	// 상품 삭제
	public void deleteProduct();
}
