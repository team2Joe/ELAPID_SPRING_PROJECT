package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.ProductQuestionDto;



public interface QnaDao {
	
	public ArrayList<ProductQuestionDto> listDao(String u_id);
	public void writeDao(String qc_name, String pq_title, String pq_content, String u_id);
	public void modifyDao(String qc_name, String pq_title, String pq_content, int pq_id);
	public ProductQuestionDto contentViewDao(int pq_id);
	public void deleteDao(int pq_id);

}
