package com.elapid.spring01.dao;

import java.util.ArrayList;

import com.elapid.spring01.dto.AdminQnADto;

public interface AdminQnADao {

	public ArrayList<AdminQnADto> aQnAListDao();
	public AdminQnADto aQnAContentDao(int pq_id);
	public AdminQnADto QnAContentDao(int pq_id);
	public void aQnAWriteDao(String anq_title, String anq_content, int pq_id, String ad_id);
	/*
	 카운트 값 가져와서 답변 여부 해보기XX
	 굳이 카운트로 할필요 없이 답글다는 write 구간에서 update로 바꿔주면 되네;; 일단 한번 go 
	 */
	public void aQnAStateDao(int pq_id);
	
}
