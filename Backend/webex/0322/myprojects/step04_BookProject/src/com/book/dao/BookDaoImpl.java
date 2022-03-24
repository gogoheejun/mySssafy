package com.book.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dto.BookDTO;

import common.DBConnection;

public class BookDaoImpl implements BookDao{
	public static BookDaoImpl bookDao;
	
	public static BookDao getBookDao() {
		if(bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
	
	//추가하기--------------------------------------------------
	@Override
	public int insertBook(BookDTO dto) {
		String sql = "insert into bookshop(isbn, title, author, company, price) values(?,?,?,?,?)";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setString(1,dto.getIsbn());
			pstmt.setString(2,dto.getTitle());
			pstmt.setString(3,dto.getAuthor());
			pstmt.setString(4,dto.getCompany());
			pstmt.setInt(5,dto.getPrice());
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		//아래도 같은 기능. 위가 좀더 깔끔하지만 아래처럼 autocommit을 푸는 기법도 있다.
//		int n = 0;
//		String sql = "insert into bookshop(isbn, title, author, company, price) values(?,?,?,?,?)";
//		
//		try(Connection conn = DBConnection.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);){
//			conn.setAutoCommit(false);
//			
//			pstmt.setString(1,dto.getIsbn());
//			pstmt.setString(2,dto.getTitle());
//			pstmt.setString(3,dto.getAuthor());
//			pstmt.setString(4,dto.getCompany());
//			pstmt.setInt(5,dto.getPrice());
//
//			try {
//				n = pstmt.executeUpdate();
//				if(n>0) {
//					conn.commit();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return n;
	}

	//전체보기---------------------------------------------------
	@Override
	public List<BookDTO> listBook() {
		
		List<BookDTO> list = new ArrayList<BookDTO>();
		BookDTO dto= null;
		String sql = "select * from bookshop order by isbn desc";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){

			while(rs.next()) {
				dto=new BookDTO();
				dto.setIsbn(rs.getString("isbn"));    // mysql의 bookshop테이블의 컬럼명:isbn, title.... 
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setCompany(rs.getString("company"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("list: "+list);
		return list;
	}
	
	//수정하기--------------------------------------------------
	@Override
	public int updateBook(BookDTO dto) {
		String sql = "update bookshop set price=? where isbn = ?";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setInt(1,dto.getPrice());
			pstmt.setString(2,dto.getIsbn());
		
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//삭제하기----------------------------------------------------
	@Override
	public int deleteBook(int isbn) {
		String sql = "delete from bookshop where isbn = ?";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setInt(1,isbn);

			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
