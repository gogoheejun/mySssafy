package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDaoImpl;
import com.book.dto.BookDTO;

/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet(name = "updateBook", urlPatterns = { "/updateBook" })
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int price = Integer.parseInt(request.getParameter("price"));
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String company=request.getParameter("company");
		
		BookDTO dto = new BookDTO(isbn, title, author, company, price);
		
		int n = BookDaoImpl.getBookDao().updateBook(dto);
		if(n>0) {
			response.sendRedirect("/bkshop/listBook");
		}else {
			System.out.println("저장실패");
		}
	}

}
