package 개인연습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1010_다리놓기 {

	static int T;
	static int R, N;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 T = sc.nextInt();
		 for(int i=0; i<T; i++) {
			 R = sc.nextInt();
			 N = sc.nextInt();
			 arr = new int[R];
			 int res = combi(N,R);
			 sb.append(res).append("\n");
			 res = 0;
		 }
		 System.out.println(sb);
	}
	
//	static int res;
	static int[] arr;
	static int combi(int N, int R) {
//		if(cnt == R) {
//			res++;
//			return;
//		}
//		
//		for(int i=start; i<N; i++) {
//			arr[cnt] = i;
//			combi(cnt+1,i+1);
//
//		}
		if(N==R || R==0) return 1;
		return combi(N-1,R-1)+combi(N-1,R);
	}
}
