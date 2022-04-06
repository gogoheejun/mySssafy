package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_최장증가부분수열 {
	
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=N; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] inputs = new int[n];
			int[][] dp = new int[2][n];
			
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				dp[0][i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<n; i++) {
				dp[1][i] = 1;
				
				for(int j=0; j<i; j++) {
					if(dp[0][j]<dp[0][i] && dp[1][i]<dp[1][j]+1) {
						dp[1][i] = dp[1][j]+1;
					}
				}
				if(max<dp[1][i]) max = dp[1][i];
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
