package ws0224;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JUNGOL1683_해밀턴순환회로2 {

	static int N;
	static int[][] mat;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		mat = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
//		System.out.println(Arrays.deepToString(mat));
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(1,0,0,visited);
		System.out.println(ans);
	}
	
	static void dfs(int cnt, int current, int sum, boolean[] visited) {
		if(sum>ans) return;
		if(cnt == N) {
			if(mat[current][0]!=0 && ans>sum+mat[current][0]) {
				ans = sum+mat[current][0];
			}
			return;
		}
		for (int i=1; i < N; i++) {
			if(mat[current][i]==0 || visited[i])continue;
			visited[i]=true;
			dfs(cnt+1,i,sum+mat[current][i], visited);
			visited[i]=false;
		}
	}

}
