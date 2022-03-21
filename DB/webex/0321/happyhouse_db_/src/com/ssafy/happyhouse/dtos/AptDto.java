package com.ssafy.happyhouse.dtos;

public class AptDto {
	private int price;
	private String dong;
	private String jibun;
	private String aptName;
	private double size;
	private int year;
	private int month;
	private int day;
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	public String getDong() {
		return dong;
	}
	
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	
	public String getJibun() {
		return jibun;
	}
	
	public void setAptName(String name) {
		this.aptName = name;
	}
	
	public String getAptName() {
		return aptName;
	}
	
	public void setSize(double area) {
		this.size = area;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setYear(int builtYear) {
		this.year = builtYear;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
}