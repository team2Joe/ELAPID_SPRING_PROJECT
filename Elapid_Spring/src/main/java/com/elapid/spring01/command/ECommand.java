package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ECommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
