package w0125.exception;

/*
$ java ExceptionEx1 2     ===> 2
$ java ExceptionEx1 a     ===> 숫자로 바꿀수 없음
$ java ExceptionEx1 0     ===> 0으로 나눌수 없음
$ java ExceptionEx1       ===> 입력값이 없음
*/
//unchecked exception
public class ExceptionEx1 {
	public static void main(String[] args) {
		int val=5;
		
		try {
			int n=Integer.parseInt(args[0]);
			System.out.println(val/n);
		}catch(Exception e) {
			System.out.println("입력값에 오류가 있음");
		}
		//-------------------------------------------
/*		int val=5;
		
		try {
			int n=Integer.parseInt(args[0]);
			System.out.println(val/n);
		}catch(NumberFormatException e) {
			System.out.println("숫자로 바꿀수 없음");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없음");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력값이 없음");
		}finally {
			System.out.println("*종료*");
		}  */
	}
}













