package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDaoImpl;

/**
 * Servlet implementation class BookDeleteServlet
 */
@WebServlet(name = "deleteBook", urlPatterns={"/deleteBook"})
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));

		int n = BookDaoImpl.getBookDao().deleteBook(isbn);
		if(n>0) {
			response.sendRedirect("/bkshop/listBook");
		}else {
			System.out.println("삭제실패");
		}
	}

}
