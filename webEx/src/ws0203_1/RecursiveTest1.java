package ws0203_1;

import java.util.Scanner;

// 1 - N 출력
public class RecursiveTest1 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		System.out.println("1 - " + N +"까지 출력 !!");
		recur(1);
	}
	
	private static void recur(int i) {             
		if(i > N)
			return;
		System.out.print(i + "  ");
		//recur(i++);    // error
		recur(i+1);      // 또는 recur(++i); 하지만, 가급적이면 recur(i+1); 로 쓰기를 권장
	}
}
//--------------------------------------------------------
/*
public class RecursiveTest01 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		System.out.println("1 - " + N +"까지 출력 !!");
		
		int i=0;
		while(N != 0) {
			System.out.print(++i + "  ");
			N--;
		}
		System.out.println();
	}
}
*/
