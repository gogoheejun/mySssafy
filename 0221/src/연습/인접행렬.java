package 연습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인접행렬 {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 정점 수
		int C = sc.nextInt();// 간선 수
		
		int[][] mat = new int[N][N];
		
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			mat[from][to] = mat[to][from] = 1;
		}
		
		bfs(mat, 0); //0번노드부터
	}
	static void bfs(int[][] mat, int start) {
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		qu.offer(start);
		visited[start] = true;
		
		while(!qu.isEmpty()) {
			int current = qu.poll();
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && mat[current][i]!=0) {
					qu.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	static void dfs(int[][] mat, boolean[] visited, int current) {
		visited[current] = true;
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && mat[current][i]!=0) {
				dfs(mat, visited, i);
			}
		}
	}
}

















