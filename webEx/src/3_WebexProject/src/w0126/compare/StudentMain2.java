package w0126.compare;

import java.util.Arrays;

class Student2 implements Comparable<Student2>{
	String name;
	int num;
	double score;
	public Student2() {
		super();
	}
	public Student2(String name, int num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}
	@Override
	public String toString() {
		return name + " " + num +" "+score;
	}
	@Override
	public int compareTo(Student2 o) {
		//return this.name.compareTo(o.name);           // 이름으로 오름차순
		//return Double.compare(o.score,this.score);    // 학점으로 내림차순
		  
		//학점으로 내림차순정렬하시오. 만약,학점이 같으면 이름으로 오름차순정렬하시오
		if(Double.compare(this.score, o.score)==0) { 
			return this.name.compareTo(o.name);
		}
		return Double.compare(o.score, this.score);
	}
}
public class StudentMain2 {
	public static void main(String[] args) {
		Student2[] s=new Student2[5];
		s[0]=new Student2("Dave",20170301, 4.5);
		s[1]=new Student2("Amie",20160301, 3.5);
		s[2]=new Student2("Emma",20180301, 2.5);
		s[3]=new Student2("Brad",20150301, 4.5);
		s[4]=new Student2("Cara",20150302, 3.5);
		
		Arrays.sort(s);
		Arrays.asList(s).forEach((ob) -> System.out.println(ob));
	}
}
