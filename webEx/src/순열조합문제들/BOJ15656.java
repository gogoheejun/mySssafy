package 순열조합문제들;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {

	static boolean[] used;
	static int[] input, numbers;
	static int N,M;
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		numbers = new int[M];
		used = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		
		permu(0);
		
		System.out.println(sb);
	}
	
	static void permu(int cnt) {
		if(cnt == M) {
			for(int num : numbers) {
				sb.append(num).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
//			if(used[i]) continue;
			
//			used[i] = true;
			numbers[cnt] = input[i];
			permu(cnt+1);
//			used[i] = false;
		}
	}
}
