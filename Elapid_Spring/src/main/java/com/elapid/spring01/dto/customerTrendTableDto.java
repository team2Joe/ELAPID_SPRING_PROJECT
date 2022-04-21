package com.elapid.spring01.dto;

public class customerTrendTableDto {

	private String date;
	private int pageview;
	private int uniquevisitor;
	private int ordercount;
	private int signupcount;
	
	public customerTrendTableDto() {
		// TODO Auto-generated constructor stub
	}

	public customerTrendTableDto(String date, int pageview, int uniquevisitor, int ordercount, int signupcount) {
		super();
		this.date = date;
		this.pageview = pageview;
		this.uniquevisitor = uniquevisitor;
		this.ordercount = ordercount;
		this.signupcount = signupcount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPageview() {
		return pageview;
	}

	public void setPageview(int pageview) {
		this.pageview = pageview;
	}

	public int getUniquevisitor() {
		return uniquevisitor;
	}

	public void setUniquevisitor(int uniquevisitor) {
		this.uniquevisitor = uniquevisitor;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public int getSignupcount() {
		return signupcount;
	}

	public void setSignupcount(int signupcount) {
		this.signupcount = signupcount;
	}

	
	
	
	
}
