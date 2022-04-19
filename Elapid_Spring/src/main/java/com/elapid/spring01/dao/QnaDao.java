package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.ProductQuestionDto;



public interface QnaDao {
	
	public ArrayList<ProductQuestionDto> listDao();
	public void writeDao(String qc_name, int pq_id, String pq_title, String pq_content, String uid);
	public void modifyDao(String qc_name, int pq_id, String pq_title, String pq_content, String uid);
	public void contentViewDao(String qc_name, String uid, int pq_id, String pq_title, String pq_content);
	public void deleteDao(int pq_id);

}
