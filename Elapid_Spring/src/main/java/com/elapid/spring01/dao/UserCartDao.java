package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.CartViewDto;

public interface UserCartDao {
	
	/*addCartDao*/
	public void AddCartDao(int p_id, String u_id);
	
	/*cartViewDao*/
	public ArrayList<CartViewDto> CartViewDao(String u_id);
		
	
}
