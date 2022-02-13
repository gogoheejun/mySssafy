package w0118;

public class ConstructorEx2 {
	
	public ConstructorEx2() {
		System.out.println("default constructor");
	}
	
	public ConstructorEx2(String str) {
		this();
		System.out.println(str + " constructor");
	}
	
	public ConstructorEx2(String str, int num) {
		this(str);   // or  this("ABC");
		System.out.println(str + "  " + num + " constructor");
	}
	
	public static void main(String[] args) {
		new ConstructorEx2("ABC", 100);
	}
}
/*
default constructor
ABC constructor
ABC  100 constructor
*/