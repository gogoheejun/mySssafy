package w0126.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//인자 2개받는 생성자, getter
class Student{
	private String name;
	private int tot;
	
	public Student(String name, int tot) {
		super();
		this.name = name;
		this.tot = tot;
	}
	public String getName() {
		return name;
	}
	public int getTot() {
		return tot;
	}
}
public class LambdaEx8 {
	public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
		list.add(new Student("kim ", 100));
		list.add(new Student("lee ", 70));
		list.add(new Student("park", 85));
		list.add(new Student("hong", 60));
		list.add(new Student("kang", 95));
		
		System.out.println("*** 정렬 전 ***");
		list.forEach((ob)-> System.out.println(ob.getName() +"  " + ob.getTot()));
		
		System.out.println("*** 정렬 후 ***");
		//list.sort((m1,m2) -> m1.getName().compareTo(m2.getName()));
		list.sort((m1,m2)->m2.getTot()-m1.getTot());
		list.forEach((ob)-> System.out.println(ob.getName() +"  " + ob.getTot()));
	}
}
/*
[참고]
System.out.println("*** 정렬 후 ***");
Collections.sort(list, new Comparator<Student>() {
	@Override
	public int compare(Student o1, Student o2) {
		//return o2.getTot()-o1.getTot();               // 점수로 내림차순
		return o1.getName().compareTo(o2.getName());    // 이름으로 오름차순
	}
});
list.forEach((ob)-> System.out.println(ob.getName() +"  " + ob.getTot()));

//System.out.println((int)'a' + "   "+(int)'o');   // 97  111
*/















