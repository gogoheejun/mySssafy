package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {
	
	static class Point{
		int r;
		int c;
		public Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] mat;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
//		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans=1;
		for(int h=1; h<=100; h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] || mat[i][j]<=h) continue;
					cnt++;
					visited[i][j] = true;
					bfs(i,j,h);
				}
			}
			ans = Math.max(ans,cnt);
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int r, int c, int height) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(r, c));
		
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==false) {
					if(mat[nr][nc] <= height) {
//						visited[nr][nc] = true;
						continue;
					}
					visited[nr][nc] = true;
					qu.offer(new Point(nr,nc));
				}
			}
		}
	}
}



















