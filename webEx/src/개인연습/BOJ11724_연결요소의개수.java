package 개인연습;

import java.util.Scanner;

public class BOJ11724_연결요소의개수 {
	
	static int N, M;
	static int[][] mat;
	static boolean[] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			mat[from][to] = mat[to][from] = 1;
		}
		
//		for(int i=1; i<N+1; i++) {
//			for(int j=1; j<N+1; j++) {
//				System.out.print(visited[i][j]);
//			}
//		}
//		
		int cnt = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(!visited[i]) {
					cnt++;
					dfs(i);
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		for(int i=1; i<=N; i++) {
			if(mat[start][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}




















