package com.elapid.spring01.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ProductImageDao {
	
	SqlSession sqlSession;
	
	// BLOB이미지 가져오기
	public Map<String, Object> getByteImage() {
	    return sqlSession.selectOne("sqlSession.getByteImage");
	}
	
}
