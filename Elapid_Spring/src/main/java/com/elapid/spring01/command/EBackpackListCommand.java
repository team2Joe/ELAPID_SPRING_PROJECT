package com.elapid.spring01.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class EBackpackListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		ProductDao countDao = new ProductDao();
		
		int count = countDao.productCount(" where c.ctg_main = 'backpack'");
		
		String tempStart = request.getParameter("page");
		
		int startPage = 0;
		int onePageCount = 3;
		
		count = (int)Math.ceil((double)count/(double)onePageCount);
		
		if(tempStart != null) {
			startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
		}
		
		dtos = dao.backpackList(startPage, onePageCount);
		
		request.setAttribute("count", count);
		request.setAttribute("list", dtos);

	}

}
