package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.ssafy.jdbctest.util.DBClose;
import com.ssafy.jdbctest.util.DBConnection;

public class ProductDaoImpl implements ProductDao{
	private static ProductDao productDao;
	
	private ProductDaoImpl() {
		
	}
	
	public static ProductDao getProductDao() {
		if(productDao==null) {
			productDao = new ProductDaoImpl();
		}
		
		return productDao;
	}
	
	
	@Override
	public List<ProductDto> searchAll() {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select product_id, product_name, product_price, product_desc, ");
			sql.append( "date_format(register_date, '%y.%m.%d') register_date \n");
			sql.append("from product");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setProductPrice(rs.getInt("product_price"));
				productDto.setProductDesc(rs.getString("product_desc"));
				productDto.setRegisterDate(rs.getString("register_date"));

				list.add(productDto);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn,pstmt,rs);
		}
		
		return list;
	}

	@Override
	public void register(ProductDto productDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDto searchById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> searchByPrice(int productPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePrice(String productId, int productPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		
	}
	
}
