package w0118;

public class ConstructorEx1 {
	
	public ConstructorEx1() {
		System.out.println("default constructor");
	}
	
	public ConstructorEx1(String str) {
		System.out.println(str + " constructor");
	}
	
	public ConstructorEx1(String str, int num) {
		System.out.println(str + "  " + num + " constructor");
	}
	
	public static void main(String[] args) {
		new ConstructorEx1();
		new ConstructorEx1("ABC");
		new ConstructorEx1("ABC", 100);
	}
}
