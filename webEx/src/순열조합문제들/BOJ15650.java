package 순열조합문제들;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15650 {

	static int N, R;
	static int[] numbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		combi(0,1);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<R; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			return;
		}
		
		for(int i=start; i<N+1; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}
	}

}
