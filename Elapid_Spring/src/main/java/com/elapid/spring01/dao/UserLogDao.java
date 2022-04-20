package com.elapid.spring01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.elapid.spring01.util.Constant;

public class UserLogDao {

//	DataSource dataSource = null;
	JdbcTemplate template;
	
	public UserLogDao() {
		// TODO Auto-generated constructor stub

		this.template = Constant.template;
	}
	
	public void userLoginLogAdd(final String uid) {
			
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query ="Insert into login_log (u_id,lo_date) values (?,now())";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, uid);
				
				return ps;
			}
		});
		
	}
	
}
