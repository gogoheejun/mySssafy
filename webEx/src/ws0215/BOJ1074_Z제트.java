package ws0215;

import java.util.Scanner;

public class BOJ1074_Z제트 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int len = (int)Math.pow(2,N);
		
		recur(len, r, c);
		System.out.println(cnt);
	}
	static int cnt = 0;
	static void recur(int len, int r, int c) {
//		System.out.println("rec: "+cnt);
		if(len == 1) return;
		//1사분면
		if(r<len/2 && c<len/2) {
			recur(len/2, r, c);
		}
		
		//2사분면
		else if(r<len/2 && c>=len/2) {
			cnt += (len*len/4);
			recur(len/2, r, c-len/2);
		}
		
		//3사분면
		else if(r>=len/2 && c<len/2) {
			cnt += (len*len/2);
			recur(len/2, r-len/2, c);
		}
		
		//4사분면
		else if(r>=len/2 && c>=len/2) {
			cnt += (len*len*3/4);
			recur(len/2, r-len/2, c-len/2);
		}
	}
}








