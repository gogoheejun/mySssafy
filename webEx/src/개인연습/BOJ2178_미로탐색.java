package 개인연습;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178_미로탐색 {

	static int N, M;
	static int[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Point{
		int r;
		int c;
		public Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new int[N][M];
//		System.out.println("===========");
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j)-48;
			}
		}

		bfs();
	}
	
	static void bfs() {
		Queue<Point> qu = new LinkedList<Point>();
		qu.offer(new Point(0,0));
		int cnt = 0;
		while(!qu.isEmpty()) {
			
			int len = qu.size();
			cnt++;
			for(int i=0; i<len; i++) {
				Point point = qu.poll();
//				System.out.println("poll: "+point );
				
				if(point.r == N-1 && point.c == M-1) {
					System.out.println(cnt);
					break;
				}
				for(int j=0; j<4; j++) {
					int nr = point.r + dr[j];
					int nc = point.c + dc[j];
					if(nr>=0 && nr<N && nc>=0 && nc<M) {
						if(mat[nr][nc] == 1) qu.offer(new Point(nr,nc));
						mat[nr][nc] = 0;
					}
				}
			}
		}
	}
}











