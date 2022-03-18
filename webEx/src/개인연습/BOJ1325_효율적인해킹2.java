package 개인연습;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1325_효율적인해킹2 {
	
	static class Computer{
		int idx;
		int cnt;
		public Computer(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	static int N, M;
	static boolean[][] mat;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			mat[from][to] = true;
		}
		
		int ans = 0;
		PriorityQueue<Computer> pq = new PriorityQueue<>(new Comparator<Computer>() {
			@Override
			public int compare(Computer o1, Computer o2) {
				return o2.cnt - o1.cnt;
			}
		});
		
		
		for(int i=1; i<N+1; i++) {
			cnt = 0;
			visited = new boolean[N+1][N+1];
			dfs(i);
			pq.offer(new Computer(i,cnt));
		}

		while(!pq.isEmpty()) {
			Computer comp = pq.poll();
			System.out.print(comp.idx+" ");
			if(comp.cnt != pq.peek().cnt) {
				break;
			}
		}
	}
	
	static int cnt;
	static void dfs(int from) {
		for(int i=1; i<N+1; i++) {
			if(mat[from][i] && !visited[from][i]) {
				visited[from][i] = true;
				cnt++;
				dfs(i);
			}
		}
	}
}
