package 개인연습;

import java.util.Scanner;

public class BOJ10844_쉬운계단수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 9;
		if(N>=2) {
			dp[2] = 17;
		}
		
		for(int i=3; i<N+1; i++) {
			if(i%2==0) {
				dp[i] = dp[i-1]*2-1;
			}else {
				dp[i] = dp[i-1]*2;
			}
		}
		
		System.out.println(dp[N]%1000000000);
	}
}
