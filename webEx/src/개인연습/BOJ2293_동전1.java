package 개인연습;

import java.util.Scanner;

public class BOJ2293_동전1 {

	static int N, K;
	static int[] coins, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		coins = new int[N];
		dp = new int[K+1];
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}

//		dp[0] = 1;
		for(int i=0; i<N; i++) {
			if(coins[i]<=K) {
				dp[coins[i]] = dp[coins[i]]+1;
			}
			for(int j=coins[i]; j<=K; j++) {

				dp[j] = dp[j] +dp[j-coins[i]];
			}

		}
		System.out.println(dp[K]);
	}
}
























