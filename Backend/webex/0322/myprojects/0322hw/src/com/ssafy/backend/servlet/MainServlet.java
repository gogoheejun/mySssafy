package com.ssafy.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ssafy.backend.dto.Book;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String action = request.getParameter("act");
			if("regist".equals(action)) {
				//회원 가입 처리
				memberRegist(request, response);
			}
	}
	private void memberRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String   isbn= request.getParameter("isbn");
		String   title= request.getParameter("title");
		String   author= request.getParameter("author");
		String   price= request.getParameter("price");
		String   desc= request.getParameter("desc");
		
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		try {
			book.setPrice(Integer.parseInt(price));
		}catch (Exception e) {
			book.setPrice(5000);
		}
		book.setDesc(desc);
		
		System.out.println(book);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<h1>");
		out.println("출력내용");
		out.println("</h1>");
		out.println(book.toString());
		
		
		out.println("</html>");
	}
}
