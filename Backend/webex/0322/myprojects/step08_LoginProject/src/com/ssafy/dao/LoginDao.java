package com.ssafy.dao;

import com.ssafy.dto.LoginDTO;

public interface LoginDao {
	public LoginDTO getLoginUser(String id, String pwd);
}
