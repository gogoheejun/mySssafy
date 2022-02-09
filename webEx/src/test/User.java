package test;

/*
-id:String   -pw:String   -name:String   -point:double
기본생성자 / 4개인자생성자 / getter&setter
*/
//entity, VO(Value Object), Bean, DTO(Data Tranfer Object)
public class User {
	private String id;
	private String pw;
	private String name;
	private double point;
	
	public User(String id, String pw, String name, double point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}
	
	public void setId(String id) {
		this.id =id;
	}
	public void setpw(String pw) {
		this.id =pw;
	}
	public void setName(String name) {
		this.id =name;
	}
	public void setPoint(String point) {
		this.id =point;
	}
	
	public double getPoint() {
		return this.point;
	}
}
