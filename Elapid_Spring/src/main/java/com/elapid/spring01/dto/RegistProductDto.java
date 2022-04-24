package com.elapid.spring01.dto;

import java.sql.Blob;

public class RegistProductDto {
	
	private String p_name;
	private int p_stock;
	private int p_price;
	private int p_size;
	private String p_mainf;
	private String ps_color;
	private String ps_material;
	private String ps_size;
	private String ps_height;
	private String ps_depth;
	private String ps_width;
	private String ps_volume;
	private String ps_weight;
	private String ctg_main;
	private String ctg_middle;
	private String ctg_sub;
	private byte[] img_thum;
	private String img_01;
	private String img_02;
	private String img_03;
	private String img_04;
	private String img_05;
	private String img_06;
	
	public RegistProductDto() {
	}

	public RegistProductDto(String p_name, int p_stock, int p_price, int p_size, String p_mainf, String ps_color, String ps_material,
			String ps_size, String ps_height, String ps_depth, String ps_width, String ps_volume, String ps_weight,
			 String ctg_main, String ctg_middle, String ctg_sub, byte[] img_thum, String img_01,
			String img_02, String img_03, String img_04, String img_05, String img_06) {
		super();
		this.p_name = p_name;
		this.p_stock = p_stock;
		this.p_price = p_price;
		this.p_size = p_size;
		this.p_mainf = p_mainf;
		this.ps_color = ps_color;
		this.ps_material = ps_material;
		this.ps_size = ps_size;
		this.ps_height = ps_height;
		this.ps_depth = ps_depth;
		this.ps_width = ps_width;
		this.ps_volume = ps_volume;
		this.ps_weight = ps_weight;
		this.ctg_main = ctg_main;
		this.ctg_middle = ctg_middle;
		this.ctg_sub = ctg_sub;
		this.img_thum = img_thum;
		this.img_01 = img_01;
		this.img_02 = img_02;
		this.img_03 = img_03;
		this.img_04 = img_04;
		this.img_05 = img_05;
		this.img_06 = img_06;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
	}

	public String getPs_color() {
		return ps_color;
	}

	public void setPs_color(String ps_color) {
		this.ps_color = ps_color;
	}

	public String getPs_material() {
		return ps_material;
	}

	public void setPs_material(String ps_material) {
		this.ps_material = ps_material;
	}

	public String getPs_size() {
		return ps_size;
	}

	public void setPs_size(String ps_size) {
		this.ps_size = ps_size;
	}

	public String getPs_height() {
		return ps_height;
	}

	public void setPs_height(String ps_height) {
		this.ps_height = ps_height;
	}

	public String getPs_depth() {
		return ps_depth;
	}

	public void setPs_depth(String ps_depth) {
		this.ps_depth = ps_depth;
	}

	public String getPs_width() {
		return ps_width;
	}

	public void setPs_width(String ps_width) {
		this.ps_width = ps_width;
	}

	public String getPs_volume() {
		return ps_volume;
	}

	public void setPs_volume(String ps_volume) {
		this.ps_volume = ps_volume;
	}

	public String getPs_weight() {
		return ps_weight;
	}

	public void setPs_weight(String ps_weight) {
		this.ps_weight = ps_weight;
	}

	public String getP_mainf() {
		return p_mainf;
	}

	public void setP_mainf(String p_mainf) {
		this.p_mainf = p_mainf;
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

	public byte[] getImg_thum() {
		return img_thum;
	}

	public void setImg_thum(byte[] img_thum) {
		this.img_thum = img_thum;
	}

	public String getImg_01() {
		return img_01;
	}

	public void setImg_01(String img_01) {
		this.img_01 = img_01;
	}

	public String getImg_02() {
		return img_02;
	}

	public void setImg_02(String img_02) {
		this.img_02 = img_02;
	}

	public String getImg_03() {
		return img_03;
	}

	public void setImg_03(String img_03) {
		this.img_03 = img_03;
	}

	public String getImg_04() {
		return img_04;
	}

	public void setImg_04(String img_04) {
		this.img_04 = img_04;
	}

	public String getImg_05() {
		return img_05;
	}

	public void setImg_05(String img_05) {
		this.img_05 = img_05;
	}

	public String getImg_06() {
		return img_06;
	}

	public void setImg_06(String img_06) {
		this.img_06 = img_06;
	}

	
}
