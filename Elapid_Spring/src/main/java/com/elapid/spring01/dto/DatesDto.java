package com.elapid.spring01.dto;

public class DatesDto {
	
	private String date;
	private String nowdate;
	
	public DatesDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DatesDto(String date, String nowdate) {
		super();
		this.date = date;
		this.nowdate = nowdate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNowdate() {
		return nowdate;
	}

	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	
	
	

}
