package 개인연습.순열조합문제들;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ15666 {

	static int N, M;
	static int[] numbers, inputs;
	static StringBuilder sb;
	static Set<String> history = new HashSet<String>();

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
			if(history.contains(Arrays.toString(numbers))) return;
			history.add(Arrays.toString(numbers));
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt+1, i);
		}
	}

}
