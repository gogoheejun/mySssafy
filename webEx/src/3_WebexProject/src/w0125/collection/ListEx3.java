package w0125.collection;

import java.util.ArrayList;
import java.util.List;

public class ListEx3 {
	public static void main(String[] args) {
		Book ob1=new Book("java","kim",100);
		Book ob2=new Book("c++","lee",250);
		Book ob3=new Book("oracle","park",300);
		
		List<Book> list=new ArrayList<>();
		list.add(ob1);
		list.add(ob2);
		list.add(ob3);

		for(Book ob:list) {
			System.out.print("책이름:"+ob.getTitle()+"  ");
			System.out.print("책저자:"+ob.getAuthor()+"  ");
			System.out.println("페이지:"+ob.getPage());
		}
	}
}
