package 개인연습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2644_촌수계산 {

	static boolean[][] mat;
	static boolean[] visited;
	static int[] dist;
	static int N;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int M = sc.nextInt(); 
		mat = new boolean[N+1][N+1];//사람수
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		for(int i=0; i<M; i++) {
			int parent = sc.nextInt();
			int son = sc.nextInt();
			mat[parent][son] = mat[son][parent] = true;
		}
		
		bfs(a,b);
		System.out.println(dist[b]);
	}
	
	static void bfs(int start, int end) {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(start);
		visited[start] = true;
		dist[start] = 0;
		
		while(!qu.isEmpty()) {
			int now = qu.poll();	
			
			if(now == end) break;
			for(int i=1; i<=N; i++) {
				if(mat[now][i] == true && visited[i]==false) {
					qu.offer(i);
					visited[i] = true;
					dist[i] = dist[now]+1;
				}
			}
		}
	}
}
