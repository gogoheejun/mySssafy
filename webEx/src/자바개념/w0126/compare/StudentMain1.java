

import java.util.Arrays;
import java.util.Comparator;

//기본생성자, 인자3개받는 생성자, toString추가
class Student{
	String name;
	int num;
	double score;
	public Student() {
		super();
	}
	public Student(String name, int num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}
	@Override
	public String toString() {
		return name + " " + num +" "+score;
	}
}
public class StudentMain1 {
	public static void main(String[] args) {
		Student[] s=new Student[5];
		s[0]=new Student("Dave",20170301, 4.5);
		s[1]=new Student("Amie",20160301, 3.5);
		s[2]=new Student("Emma",20180301, 2.5);
		s[3]=new Student("Brad",20150301, 4.5);
		s[4]=new Student("Cara",20150302, 3.5);
		
		//------------------------------------------------------
		System.out.println("** 학점으로 내림차순 **");
		Arrays.sort(s, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				//return (int)(o2.score - o1.score);
				return Double.compare(o2.score, o1.score);
			}
		});
		
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);    
		}
		//------------------------------------------------------
		System.out.println("\n** 이름으로 오름차순 **");
		Arrays.sort(s, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);    //or  s[i].toString()
		}
		//-----------------------------------------------
		//학점으로 내림차순정렬하시오. 만약,학점이 같으면 이름으로 오름차순정렬하시오
		System.out.println("\n** 학번과 이름으로 정렬 **");
		Arrays.sort(s, (o1, o2) -> {
			if (Double.compare(o2.score, o1.score) == 0) {
				return o1.name.compareTo(o2.name);
			}
			return Double.compare(o2.score, o1.score);
		});
		Arrays.asList(s).forEach((ob) -> System.out.println(ob));
	}
}
