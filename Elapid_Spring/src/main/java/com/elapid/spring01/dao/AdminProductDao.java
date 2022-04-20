package com.elapid.spring01.dao;

import com.elapid.spring01.dto.ProductDetailDto;

public interface AdminProductDao {
	
	public void registerProduct();
	
	public ProductDetailDto modifyProductView();
	
	public void modifyProduct();
	
	public void deleteProduct();
}
