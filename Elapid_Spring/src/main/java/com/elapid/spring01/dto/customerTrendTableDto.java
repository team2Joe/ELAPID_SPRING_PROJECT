package com.elapid.spring01.dto;

public class customerTrendTableDto {

	private String date;
	private int pageview;
	private int uniquevisitor;
	private int ordercount;
	private int signupcount;
	private String p_name;
	private String ctg_main;
	private String ctg_middle;
	private String ctg_sub;
	private String funnel;
	
	
	public customerTrendTableDto() {
		// TODO Auto-generated constructor stub
	}


	public customerTrendTableDto(String date, int pageview, int uniquevisitor, int ordercount, int signupcount,
			String p_name, String ctg_main, String ctg_middle, String ctg_sub, String funnel) {
		super();
		this.date = date;
		this.pageview = pageview;
		this.uniquevisitor = uniquevisitor;
		this.ordercount = ordercount;
		this.signupcount = signupcount;
		this.p_name = p_name;
		this.ctg_main = ctg_main;
		this.ctg_middle = ctg_middle;
		this.ctg_sub = ctg_sub;
		this.funnel = funnel;
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


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getCtg_main() {
		return ctg_main;
	}


	public void setCtg_main(String ctg_main) {
		this.ctg_main = ctg_main;
	}


	public String getCtg_middle() {
		return ctg_middle;
	}


	public void setCtg_middle(String ctg_middle) {
		this.ctg_middle = ctg_middle;
	}


	public String getCtg_sub() {
		return ctg_sub;
	}


	public void setCtg_sub(String ctg_sub) {
		this.ctg_sub = ctg_sub;
	}


	public String getFunnel() {
		return funnel;
	}


	public void setFunnel(String funnel) {
		this.funnel = funnel;
	}

	
	
	
	
}
