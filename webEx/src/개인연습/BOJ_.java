package 개인연습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_ {
	
	static class Virus{
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(ans);
	}
	
	static void dfs(int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		int[][] virus_map = new int[N][M];
		Queue<Virus> qu = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus_map[i][j]==2) {
					qu.add(new Virus(i, j));
				}
			}
		}
		
		while(!qu.isEmpty()) {
			Virus v = qu.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.x +dr[i];
				int nc = v.y +dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(virus_map[nr][nc]==0) {
						virus_map[nr][nc] = 2;
						qu.add(new Virus(nr, nc));
					}
				}
			}
		}
		
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(virus_map[i][j]==0) cnt++;
			}
		}
		ans = Math.max(ans,cnt);
	}
}

















