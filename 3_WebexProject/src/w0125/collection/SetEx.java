package w0125.collection;

import java.util.HashSet;
import java.util.Set;

//Set: 중복허용X, 순서유지X
public class SetEx {
	@SuppressWarnings(value="unchecked")  // type을 확인하지 않는 Annotation
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")     // 제네릭도 확인 X
		Set set=new HashSet();   
		set.add("one");
		set.add(2);                       // int --> new Integer(2)로 자동객체변환     
		set.add(new Float(3.0f));
		set.add(4.0f);
		set.add(3.0f); 
		set.add(new Integer(2));
		set.add(new Double(4.0));
		System.out.println(set);
	}
}
