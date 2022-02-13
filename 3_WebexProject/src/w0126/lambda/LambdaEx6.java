package w0126.lambda;

@FunctionalInterface
interface Function{
   public double calc(int a, int b);
   
   default public double calc(double a, double b) {
	   return a/b;
   }
   default public String view(String title) {
	   return title +":";
   }
}
public class LambdaEx6 {
	public static void main(String[] args) {
		Function f1=(a,b)->a+b;
		Function f2=(a,b)->a-b;
		
		System.out.println(f1.view("더하기") + f1.calc(10, 20) );
		System.out.println(f2.view("빼기") + f2.calc(10, 20) );
		System.out.println(f2.view("나누기")+ f2.calc(5.0, 2.0));
	}
}
