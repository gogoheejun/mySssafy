package ws0225;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576_토마토 {
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, N;
	static int[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};//상우하좌
	static Queue<Point> qu = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		mat = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mat[i][j] = sc.nextInt();
				if(mat[i][j] == 1) {
					qu.offer(new Point(i,j));
				}
			}
		}

		int ans = bfs();
		ans -=1;
		//체크
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j] == 0) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
	}
	
	static int bfs() {
		int ans = 0;
		while(!qu.isEmpty()) {
			int len = qu.size();
			
			ans++;
//			System.out.println("카운트증가: "+ans);
			for(int t=0; t<len; t++) {
				Point p = qu.poll();
				
				for(int i=0; i<4; i++) {
					
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M) {
						if(mat[nr][nc] == 0) {
							mat[nr][nc] = 1;
							qu.offer(new Point(nr,nc));
//							System.out.println("익었다!"+nr+", "+nc);
						}
					}
				}
			}
		}
		return ans;
	}
}
