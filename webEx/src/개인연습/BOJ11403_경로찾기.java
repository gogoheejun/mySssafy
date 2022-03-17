package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11403_경로찾기 {
	
	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int[][] mat;
	static int[][] ansMat;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		ansMat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j]  = Integer.parseInt(st.nextToken());
//				if(i==j) ansMat[i][j] = 1;
			}
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			dfs(i,i);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(ansMat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	static void dfs(int start, int r) {
		
		for(int c=0; c<N; c++) {
			if(visited[c]) continue;
			if(mat[r][c] == 1) {
				ansMat[start][c] = 1;
				visited[c] = true;
				dfs(start,c);
			}
		}
	}
	
}

