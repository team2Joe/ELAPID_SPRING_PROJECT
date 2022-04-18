package com.elapid.spring01.dto;

import java.sql.Timestamp;

public class ProductDto {

	private int p_id;
	private String p_name;
	private String p_stock;
	private int p_price;
	private int p_discountprice;
	private int p_size;
	private String p_mainf;
	private String p_colorimg;
	private String p_colorname;
	private Timestamp p_date;
	private String p_desc;
	private String p_clickcount;
	
	// 상품 메인 사진 컬럼필드 추가!!

	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}


	public ProductDto(int p_id, String p_name, String p_stock, int p_price, int p_discountprice, int p_size,
			String p_mainf, String p_colorimg, String p_colorname, Timestamp p_date, String p_desc, String p_clickcount
			) {

		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_stock = p_stock;
		this.p_price = p_price;
		this.p_discountprice = p_discountprice;
		this.p_size = p_size;
		this.p_mainf = p_mainf;
		this.p_colorimg = p_colorimg;
		this.p_colorname = p_colorname;
		this.p_date = p_date;
		this.p_desc = p_desc;
		this.p_clickcount = p_clickcount;


	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_stock() {
		return p_stock;
	}

	public void setP_stock(String p_stock) {
		this.p_stock = p_stock;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_discountprice() {
		return p_discountprice;
	}

	public void setP_discountprice(int p_discountprice) {
		this.p_discountprice = p_discountprice;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
	}

	public String getP_mainf() {
		return p_mainf;
	}

	public void setP_mainf(String p_mainf) {
		this.p_mainf = p_mainf;
	}

	public String getP_colorimg() {
		return p_colorimg;
	}

	public void setP_colorimg(String p_colorimg) {
		this.p_colorimg = p_colorimg;
	}

	public String getP_colorname() {
		return p_colorname;
	}

	public void setP_colorname(String p_colorname) {
		this.p_colorname = p_colorname;
	}

	public Timestamp getP_date() {
		return p_date;
	}

	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public String getP_clickcount() {
		return p_clickcount;
	}

	public void setP_clickcount(String p_clickcount) {
		this.p_clickcount = p_clickcount;
	}

	
}