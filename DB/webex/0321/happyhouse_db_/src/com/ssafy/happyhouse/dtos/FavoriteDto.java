package com.ssafy.happyhouse.dtos;

public class FavoriteDto {
	private int index;
	private String regionCode;
	private String gugun;
	private String dong;
	private String userId;
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	public String getRegionCode() {
		return regionCode;
	}
	
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	
	public String getGugun() {
		return gugun;
	}
	
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	public String getDong() {
		return dong;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
}
