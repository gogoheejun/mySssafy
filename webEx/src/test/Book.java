package test;

//Entity, VO(value Object), Bean, DTO(Data Tranfer Object)
//기본생성자, 인자3개받는 생성자, getter, setter 추가
public class Book {
	private String title;
	private String author;
	private int page;
	
	public Book(String title, String author, int page) {
		this.title = title;
		this.author = author;
		this.page = page;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getPage() {
		return this.page;
	}
	
}
