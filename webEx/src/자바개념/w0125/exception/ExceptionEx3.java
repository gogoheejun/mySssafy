package w0125.exception;

//사용자 정의 예외처리
/*
A
A는 소문자로 a입니다

a
a는 대문자로 A입니다

+
Exception in thread "main" w0125.exception.NotAlphabet: +는 영문 대문자 또는 소문자가 아닙니다
	at w0125.exception.ExceptionEx3.main(ExceptionEx3.java:19)
*/
class NotAlpabet extends Exception{
	public NotAlpabet(char alpa) {
		super(alpa + "는 영문 대문자 또는 소문자가 아닙니다");
	}
}
public class ExceptionEx3 {
	public static void main(String[] args) throws NotAlpabet{
		char alpa=args[0].charAt(0);
		
		if(alpa>='A' && alpa<='Z'){
			System.out.println(alpa + "는 소문자로 " + (char)(alpa+32) +"입니다");
			
		}else if(alpa>='a' && alpa<='z'){
			System.out.println(alpa + "는 대문자로 " + (char)(alpa-32) +"입니다");
		}else {
			throw new NotAlpabet(alpa);
		}
	}
}
