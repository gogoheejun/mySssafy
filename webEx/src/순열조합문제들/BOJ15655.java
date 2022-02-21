package 순열조합문제들;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15655 {

	static int N, M;
	static int[] numbers, inputs;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		inputs = new int[N];
		numbers = new int[M];
		for(int i=0; i<N; i++) {
			inputs[i] = sc.nextInt();
		}
		Arrays.sort(inputs);
		combi(0,0);
		System.out.println(sb);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt+1, i+1);
		}
	}

}
