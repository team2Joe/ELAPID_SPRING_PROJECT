package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.customerTrendTableDto;

public interface AdminTableDao {
	
	public ArrayList<customerTrendTableDto> customerTrendTable(String startdate,String enddate, String period);
	public String test(String startdate,String enddate, String period);
}
