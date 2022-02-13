package w0126.lambda;

//람다식 형태--------------------------------------------------
public class LambdaEx1{
	public static void main(String[] args) {
		Print m=()-> System.out.println("Hello Lambda");
		m.view();
	}
}
//익명 중첩클래스(anonymous inner class)----------------------
/*
public class LambdaEx1{
	public static void main(String[] args) {
		Print m=new Print() {
			@Override
			public void view() {
				System.out.println("Hello Lambda");
			}
		};
		m.view();
	}
}
*/
// 일반메서드 형태------------------------------------------
/*
public class LambdaEx1 implements Print{
	@Override
	public void view() {
		System.out.println("Hello Lambda");
	}
	public static void main(String[] args) {
		new LambdaEx1().view();
	}
}
*/
