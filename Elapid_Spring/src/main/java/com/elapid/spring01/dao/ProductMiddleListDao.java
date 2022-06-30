package com.elapid.spring01.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.elapid.spring01.dto.ProductListDto;
import com.elapid.spring01.util.Constant;

public class ProductMiddleListDao {
	
	JdbcTemplate template;
	
	public ProductMiddleListDao() {
		
		this.template = Constant.template;
	}
	
	public ArrayList<ProductListDto> middleListDao(String ctg_middle, int startPage, int onePageCount){
		
		String query = "SELECT * FROM PRODUCT_IMAGE I"
				+ "	JOIN IMAGE_DETAIL ID"
				+ "	ON I.IMG_ID = ID.IMG_ID"
				+ "	JOIN PRODUCT P"
				+ "	ON P.P_ID = ID.P_ID"
				+ "	JOIN CATEGORY_DETAIL CD"
				+ "	ON P.P_ID = CD.P_ID"
				+ "	JOIN CATEGORY C"
				+ "	ON C.CTG_ID = CD.CTG_ID"
				+ "	JOIN PRODUCT_DETAIL PD"
				+ "	ON PD.P_ID = P.P_ID"
				+ "	JOIN PRODUCT_SPEC S"
				+ "	ON S.PS_ID = PD.PS_ID"
				+ "	WHERE C.CTG_MIDDLE = '"+ ctg_middle +"'"
				+ " limit " + startPage + ", " + onePageCount;
		
		ArrayList<ProductListDto> dtos = (ArrayList<ProductListDto>)template.query(query, new BeanPropertyRowMapper<ProductListDto>(ProductListDto.class));
		
		return dtos;
	}
	
}
