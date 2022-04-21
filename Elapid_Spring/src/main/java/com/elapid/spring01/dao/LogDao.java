package com.elapid.spring01.dao;

import com.elapid.spring01.dto.DatesDto;

public interface LogDao {
	
	public void visitorCount(String ip,String funnel);
	public DatesDto returnLatestDateTime(String ip);
	
	
	
}
