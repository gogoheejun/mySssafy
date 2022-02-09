package w0125.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 클래스명 : ExceptionEx2 
str:String
+ExceptionEx2()            --> input() 호출
+input():void              --> BufferedReader로 입력받기
+output():void             --> 출력하기

[출력화면]
문자열을 입력하시오 : abcd
결과 : abcd
*/ 
//checked exception
public class ExceptionEx2 {
	String str;
	
	public ExceptionEx2() {
		input();
	}
	
	public void input() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열을 입력하시오: ");
		try {
			str=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void output() {
		System.out.println("결과:"+str);
	}
	public static void main(String[] args) {
		new ExceptionEx2().output();
	}
}
//--------------------------------------------------------------------------------
/*
public class ExceptionEx2 {
	String str;
	
	public ExceptionEx2() throws IOException {
		input();
	}
	
	public void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열을 입력하시오: ");
		str=br.readLine();
	}
	
	public void output() {
		System.out.println("결과:"+str);
	}
	public static void main(String[] args) throws IOException {
		new ExceptionEx2().output();
	}
}
*/