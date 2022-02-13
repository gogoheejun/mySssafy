package w0125.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
찾는 도서명: java
java kim 100

찾는 도서명: php
찾는 도서가 없습니다
*/
public class MapEx2 {
	public static void main(String[] args) {
		Book ob1 = new Book("java", "kim", 100);
		Book ob2 = new Book("c++", "lee", 250);
		Book ob3 = new Book("oracle", "park", 300);

		// map에 ob1,ob2,ob3를 추가하시오
		Map<String, Book> books = new HashMap<>();
		books.put(ob1.getTitle(), ob1);
		books.put(ob2.getTitle(), ob2);
		books.put(ob3.getTitle(), ob3);

		Set<String> keys=books.keySet();
		for(String n:keys) {
			System.out.println(books.get(n).getTitle());
		}
		//--------------------------------------------------------------
/*		Scanner sc = new Scanner(System.in);
		System.out.print("찾는 도서명: ");
		String title = sc.next();

		if(books.get(title)==null) {
			System.out.println("찾는 도서가 없습니다.");
		}else {
			System.out.println("책이름 : " + books.get(title).getTitle());
			System.out.println("책저자 : " + books.get(title).getAuthor());
			System.out.println("페이지 : " + books.get(title).getPage());
		}
*/
	}
}
