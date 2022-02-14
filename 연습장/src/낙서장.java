import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 낙서장 {
	public static void main(String[] args) {
		Person p1 = new Person(10);
		Person p2 = new Person(20);
		Person p3 = new Person(30);
		Person p4 = new Person(40);
		
		Person[] arr = new Person[4];
		arr[0] = p3;
		arr[1] = p2;
		arr[2] = p4;
		arr[3] = p1;
		Arrays.sort(arr, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		System.out.println(Arrays.toString(arr));
	}
}

class Person{
	String name;
	int age;
	
	Person(int age){
		this.name = "익명";
		this.age = age;
	}
	
	@Override
	public String toString() {
		return age+"";
	}
}