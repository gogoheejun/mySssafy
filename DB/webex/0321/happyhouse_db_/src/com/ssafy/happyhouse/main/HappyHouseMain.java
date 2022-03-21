package com.ssafy.happyhouse.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ssafy.happyhouse.daos.*;
import com.ssafy.happyhouse.dtos.*;

public class HappyHouseMain {

	BufferedReader in;
	final UserDao userDao = new UserDao();
	final FavoriteDao favoriteDao = new FavoriteDao();
	final AptDao aptDao = new AptDao();
	UserDto currentUser = null;

	public HappyHouseMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new HappyHouseMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 즐겨찾기 추가");
			System.out.println("4. 즐겨찾기 조회");
			System.out.println("5. 동으로 검색");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : register();break;
				case 2 : login();break;
				case 3 : addFavorite();break;
				case 4 : showFavorite();break;
				case 5 : searchByDong();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	private void register() {
//		System.out.println("register");
//		유효성 검사는 생략할게요!!!
		try {
			System.out.println("--------------------- 회원가입 ---------------------");
			System.out.print("아이디 : ");
			String id = in.readLine();
			System.out.print("비밀번호 : ");
			String password = in.readLine();
			System.out.print("이름 : ");
			String name = in.readLine();
			System.out.print("주소 : ");
			String address = in.readLine();
			System.out.print("전화번호 : ");
			String telephone = in.readLine();
			
			UserDto userDto = new UserDto();
			userDto.setId(id);
			userDto.setPassword(password);
			userDto.setName(name);
			userDto.setAddress(address);
			userDto.setTelephone(telephone);
			
			userDao.insertUser(userDto);
			System.out.println("-------------------------------------------------");
			System.out.println("회원가입 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void login() {
//		System.out.println("updatePrice");
		try {
			System.out.println("--------------------- 로그인 ---------------------");
			System.out.print("아이디 : ");
			String id = in.readLine();
			System.out.print("비밀번호 : ");
			String password = in.readLine();
			
			UserDto user = userDao.selectUserById(id);
			if (user.getPassword().equals(password)) {
				currentUser = user;
				System.out.println("-------------------------------------------------");
				System.out.println("로그인 성공!!!!!");
				System.out.println("-------------------------------------------------");
			} else {
				System.out.println(user.getPassword());
				System.out.println("-------------------------------------------------");
				System.out.println("로그인 실패!!!!!");
				System.out.println("-------------------------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addFavorite() {
//		System.out.println("deleteProduct");
		try {
			System.out.println("--------------------- 즐겨찾기 추가 ---------------------");
			System.out.print("지역번호 : ");
			String regionCode = in.readLine();
			System.out.print("법정동 : ");
			String dong = in.readLine();
			
			FavoriteDto favoriteDto = new FavoriteDto();
			favoriteDto.setRegionCode(regionCode);
			favoriteDto.setDong(dong);
			favoriteDto.setUserId(currentUser.getId());
			
			favoriteDao.insertFavorite(favoriteDto);
			System.out.println("-------------------------------------------------");
			System.out.println("즐겨찾기 추가 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showFavorite() {
//		System.out.println("deleteProduct");
		System.out.println("--------------------- 즐겨찾기 조회 ---------------------");
		
		ArrayList<FavoriteDto> list = favoriteDao.selectAll(currentUser.getId());
		
		for (FavoriteDto favorite : list) {
			System.out.println("# " + favorite.getGugun() + " " + favorite.getDong() + " ");
		}
		System.out.println("-------------------------------------------------");
	}
	
	
	private void searchByDong() {
//		System.out.println("deleteProduct");
		try {
			System.out.println("--------------------- 동으로 검색 ---------------------");
			System.out.print("법정동 : ");
			String dong = in.readLine();
			
			ArrayList<AptDto> list = aptDao.selectAptByDong(dong);
			
			for (AptDto apt : list) {
				System.out.print(apt.getPrice() + "\t");
				System.out.print(apt.getDong() + "\t");
				System.out.print(apt.getJibun() + "\t");
				System.out.print(apt.getAptName() + "\t");
				System.out.print(apt.getSize() + "\t");
				System.out.print(apt.getYear() + "\t");
				System.out.print(apt.getMonth() + "\t");
				System.out.print(apt.getDay() + "\t");
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}