package w0126.lambda;

//람다식-----------------------------------------------
public class LambdaEx2 {
	public static void main(String[] args) {
		//new Thread(() -> System.out.println("Hello Thread")).start();
		Runnable th= ()-> System.out.println("Hello Thread");
	    th.run();
	}
}
//익명함수---------------------------------------------
/*
public class LambdaEx2 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Thread");
			}
		}).start();
	}
}
*/
//일반 메서드---------------------------------------------
/*
class MyThread implements Runnable{
	@Override
	public void run() {
		System.out.println("Hello Thread");
	}
}
public class LambdaEx2 {
	public static void main(String[] args) {
//		MyThread ob=new MyThread();
//		Thread th=new Thread(ob);
//		th.start();
		
		new Thread(new MyThread()).start();
	}
}
*/
