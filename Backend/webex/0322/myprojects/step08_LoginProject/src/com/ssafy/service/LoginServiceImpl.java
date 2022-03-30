package com.ssafy.service;

import com.ssafy.dao.LoginDaoImpl;
import com.ssafy.dto.LoginDTO;

public class LoginServiceImpl implements LoginService{

	public static LoginServiceImpl loginService;
	public static LoginDaoImpl loginDaoImpl;
	
	public static LoginService getLoginService() {
		if(loginService==null) {
			loginService = new LoginServiceImpl();
		}
		loginDaoImpl = (LoginDaoImpl)LoginDaoImpl.getLoginDao();
		return loginService;
	}
	
	@Override
	public LoginDTO getLoginUser(String id, String pwd) {
		
		LoginDTO dto = loginDaoImpl.getLoginUser(id, pwd);
		return dto;
	}

}
