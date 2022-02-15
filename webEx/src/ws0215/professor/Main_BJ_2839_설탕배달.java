package ws0215.professor;

//https://www.acmicpc.net/problem/2839
/*
[입력]    [출력]
18         4
4         -1
6          2
9          3
11         3
*/
import java.util.Scanner;

public class Main_BJ_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		for (int i = 1; i < dp.length; i++) {
			if (i%3 == 0) {
				dp[i] = i / 3;
			} else {
				dp[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 5; i < dp.length; i++) {
			if (dp[i-5] != Integer.MAX_VALUE && dp[i] > dp[i-5] + 1) {
				dp[i] = dp[i-5] + 1;
			}
		}
		System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
		sc.close();
	} 
}
// 12876kb / 112ms


















