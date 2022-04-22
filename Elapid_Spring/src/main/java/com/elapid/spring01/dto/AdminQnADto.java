package com.elapid.spring01.dto;

public class AdminQnADto {
	
	private int pq_id;
	private String qc_name;
	private String u_id;
	private String pq_title;
	private String pq_content;
	private int anq_id;
	private String anq_title;
	private String anq_content;
	private String ad_id;
	private String anq_state;
	
	
	public AdminQnADto() {
		// TODO Auto-generated constructor stub
	}

	public AdminQnADto(String qc_name, String u_id, int pq_id, String pq_title, String pq_content, String anq_state) {
		super();
		this.qc_name = qc_name;
		this.u_id = u_id;
		this.pq_id = pq_id;
		this.pq_title = pq_title;
		this.pq_content = pq_content;
		this.anq_state = anq_state;
	}

	
	public AdminQnADto(String qc_name, String u_id, String pq_title, String pq_content) {
		super();
		this.qc_name = qc_name;
		this.u_id = u_id;
		this.pq_title = pq_title;
		this.pq_content = pq_content;
	}

	
	public AdminQnADto(int pq_id, String qc_name, String u_id, String pq_title, String pq_content, int anq_id,
			String anq_title, String anq_content, String ad_id, String anq_state) {
		super();
		this.pq_id = pq_id;
		this.qc_name = qc_name;
		this.u_id = u_id;
		this.pq_title = pq_title;
		this.pq_content = pq_content;
		this.anq_id = anq_id;
		this.anq_title = anq_title;
		this.anq_content = anq_content;
		this.ad_id = ad_id;
		this.anq_state = anq_state;
	}


	public String getAnq_state() {
		return anq_state;
	}

	public void setAd_state(String anq_state) {
		this.anq_state = anq_state;
	}

	public String getQc_name() {
		return qc_name;
	}

	public void setQc_name(String qc_name) {
		this.qc_name = qc_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getPq_id() {
		return pq_id;
	}

	public void setPq_id(int pq_id) {
		this.pq_id = pq_id;
	}

	public String getPq_title() {
		return pq_title;
	}

	public void setPq_title(String pq_title) {
		this.pq_title = pq_title;
	}

	public String getPq_content() {
		return pq_content;
	}

	public void setPq_content(String pq_content) {
		this.pq_content = pq_content;
	}

	public int getAnq_id() {
		return anq_id;
	}

	public void setAnq_id(int anq_id) {
		this.anq_id = anq_id;
	}

	public String getAnq_title() {
		return anq_title;
	}

	public void setAnq_title(String anq_title) {
		this.anq_title = anq_title;
	}

	public String getAnq_content() {
		return anq_content;
	}

	public void setAnq_content(String anq_content) {
		this.anq_content = anq_content;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	
	
}
