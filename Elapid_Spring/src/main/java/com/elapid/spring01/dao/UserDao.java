package com.elapid.spring01.dao;

import com.elapid.spring01.dto.UserDto;

public interface UserDao {
	
	public int loginCheck(String uid, String upassword);
	public String nameReturn(String uid);
	public void userAdd(String uid,String upwd,String uname, String uemail, String utel, String ugender, String ubirthdate);
	public UserDto profileView(String suid);
	public void profileModify(String uemail, String upwd, String utel, String ugender, String ubirthdate,String uid);
	public void profileDelete(String uid);
	
}
