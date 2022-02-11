package IM대비;

import java.util.Scanner;

public class No17_BOJ2559_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] temps = new int[N];
		for(int i=0; i<N; i++) {
			temps[i] = sc.nextInt();
		}
		int ans = -100000;
		for(int i=0; i<N-(K-1); i++) {
			int sum = 0;
			for(int j=i; j<i+K; j++) {
//				System.out.print(j);
				sum += temps[j];
			}
			ans = Math.max(ans,sum);
		}
		
		System.out.println(ans);
	}
}
