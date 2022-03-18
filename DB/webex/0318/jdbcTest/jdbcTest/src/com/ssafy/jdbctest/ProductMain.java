package com.ssafy.jdbctest;

import java.util.List;

public class ProductMain {
	public static void main(String[] args) {
		new ProductMain().searchAll();
	}
	
	private void searchAll() {
		List<ProductDto> list = ProductDaoImpl.getProductDao().searchAll();
		showList(list);
	}
	
	private void showList(List<ProductDto> list) {
		System.out.println("===================================== 상품 목록 =====================================");
		System.out.println("상품아이디\t상품이름\t상품가격\t등록일\t\t상품설명");
		System.out.println("-------------------------------------------------------------------------------------");
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
