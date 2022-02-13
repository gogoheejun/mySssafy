package w0125.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List: 중복허용O, 순서유지O
public class ListEx1 {
	public static void main(String[] args) {
		List list=new ArrayList();   
		list.add("one");
		list.add(2);                           
		list.add(new Float(3.0f));
		list.add(4.0f);
		list.add(3.0f); 
		list.add(new Integer(2));
		list.add(new Double(4.0));
		System.out.println(list);
		
		//list.remove(2);              // index의 의미(순번)
		list.remove(new Integer(2));   // Object의 의미(값)
		
		Iterator iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());			
		}
	}
}










