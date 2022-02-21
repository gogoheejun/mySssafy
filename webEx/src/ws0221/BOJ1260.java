package ws0221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

	static int N, M, V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		int[][] mat = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			mat[from][to] = mat[to][from] = 1;
		}
		
		dfs(mat, new boolean[N+1], V);
		sb.setLength(sb.length()-1);
		sb.append("\n");
//		System.out.println(sb);
		bfs(mat, V);
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true; //큐에 들어갈때 방문체크함!!
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println(current);
			sb.append(current).append(" ");
			
			//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(int j=1; j<N+1; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0) {
					queue.offer(j);
					visited[j] = true;
				}
			}
		}
	}

	static StringBuilder sb = new StringBuilder();
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		
		sb.append(current).append(" ");
		
		//current 정점의 인접정점 처리(단, 방문하지 않은 정점만)
		for(int j=1; j<N+1; j++) {
			if(!visited[j] && adjMatrix[current][j]!=0) {
				dfs(adjMatrix, visited, j);
			}
		}	
	}
	
	
}
