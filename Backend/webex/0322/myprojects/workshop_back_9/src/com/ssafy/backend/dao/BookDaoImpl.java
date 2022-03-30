package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;

public class BookDaoImpl implements BookDao{
	
	private static BookDaoImpl bookDaoImpl;
	
	public static BookDaoImpl getBookDaoImpl() {
		if(bookDaoImpl==null) {
			bookDaoImpl = new BookDaoImpl();
		}
		return bookDaoImpl;
	}

	@Override
	public int insert(Book book) throws SQLException {
		int rows = 0;
		String sql = "insert into book values(?,?,?,?,?,?)";
		try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			String isbn = book.getIsbn();
			String title = book.getTitle();
			String author = book.getAuthor();
			int price = book.getPrice();
			String desc = book.getDesc();
			String img = book.getImg();
			
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setInt(4, price);
			pstmt.setString(5, desc);
			pstmt.setString(6, img);
			
			rows =pstmt.executeUpdate();
//			System.out.println("업뎃결과: "+rows);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패========");
			e.printStackTrace();
		}
		System.out.println("업뎃결과: "+rows);
		return rows;
	}

	@Override
	public List<Book> select() throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "select * from book";
		try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {		
				Book book = new Book(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getInt("price"),
									rs.getString("desc"),
									rs.getString("img"));
				list.add(book);
			}
			System.out.println("트라이");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("캐치");
		}
		System.out.println("books: "+list);
		return list;
	}

}
