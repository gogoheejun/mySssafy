package 순열조합문제들;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15651 {

	static int N, R;
	static int[] numbers;
	static boolean[] selected[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		permu(0);
	}
	
	static void permu(int cnt) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<R; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			numbers[cnt] = i; 
			permu(cnt+1);
		}
	}

}
