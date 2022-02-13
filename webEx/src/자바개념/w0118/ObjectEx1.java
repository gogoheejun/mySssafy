package w0118;

/*  
-(private) , +(public) , #(protected)

클래스명 : Person
  +name:String          
  +age:int
  +score:float
                       
  +setPerson(na:String, a:int, s:float) : void
  +viewPerson():void 
*/
// ObjectEx1.java  ----> ObjectEx1.class    Person.class
class Person{
	public String name;   // 필드(field), 멤버변수
	public int age;
	public float score;
	
	public void setPerson(String name, int age, float score) {   //메서드(method),멤버함수
		this.name=name;
		this.age=age;
		this.score=score;
	}
	public void viewPerson() {
		System.out.println("이름:" +name);
		System.out.println("나이:" +age);
		System.out.println("점수:" +score);
	}
}
public class ObjectEx1 {
	public static void main(String[] args) {
		Person p1=new Person();
		p1.setPerson("홍길동", 22, 75.3f);
		p1.viewPerson();
		
		Person p2=new Person();
		p2.setPerson("이순신", 23, 85.3f);
		p2.viewPerson();
	}
}





