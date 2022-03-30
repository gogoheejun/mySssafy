package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dao.LoginDaoImpl;
import com.ssafy.dto.LoginDTO;
import com.ssafy.service.LoginService;
import com.ssafy.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		switch (action) {
		case "login":
			doLogin(request,response);
			break;
		}
	}
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id+", "+pwd);
		
		LoginDTO dto = LoginServiceImpl.getLoginService().getLoginUser(id, pwd);
		if(dto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("logOK", dto);
			response.sendRedirect("/log/logtest/loginOk.jsp");
		}else {
			response.sendRedirect("/log/logtest/loginFail.jsp");
		}
	}

}
