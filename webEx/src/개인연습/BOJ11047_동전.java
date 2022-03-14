package 개인연습;

import java.util.Scanner;

public class BOJ11047_동전 {

	static int N, K;
	static int[] coins;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			if(coins[i] <= K) {
				count += (K/coins[i]);
				K = K%coins[i];
			}
		}
		
		System.out.println(count);
	}
	
}
