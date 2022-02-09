package w0118;

/*기본생성자(default constructor)
-생성자가 구현되어 있지 않으면 자동 생성된다
-생성자가 1개라도 구현되어 있으면 기본생성자는 자동생성이 안된다
*/
class Emp{
	private String name="이순신";
	private int age=25;
	
	public Emp() {  //default 생성자는 쓰던 안쓰던 만들어 두는 것이 좋다
		
	}
	
	public Emp(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void view() {
		System.out.println(name+"  "+age);
	}
}
public class ConstructorEx5 {
	public static void main(String[] args) {
		Emp ob1=new Emp("홍길동",27);
		ob1.view();
		
		Emp ob2=new Emp();
		ob2.view();
	}
}
