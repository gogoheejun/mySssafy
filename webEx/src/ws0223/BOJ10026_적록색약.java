package ws0223;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026_적록색약 {

	static int N;
	static char[][] mat;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};//우하좌상
	static boolean[][] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mat = new char[N][N];
		
		for(int i=0; i<N; i++) {
			mat[i] = sc.next().toCharArray();
		}
		
		//정상
		int cntNotBlind = 0;
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					cntNotBlind++;
					bfs(i,j, false);
				}
			}
		}
		
		//색약
		int cntBlind = 0;
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					cntBlind++;
					bfs(i,j, true);
				}
			}
		}
		System.out.println(cntNotBlind+" "+cntBlind);

	}
	
	static void bfs(int r, int c, boolean isBlind) {
		if(check[r][c]) return;
		Point point = new Point(r,c);
		Queue<Point> qu = new LinkedList<Point>();
		qu.offer(point);
		
		while(!qu.isEmpty()) {
			Point current = qu.poll();
			
			for(int i=0; i<4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !check[nr][nc]) {
					if(mat[nr][nc] == mat[current.r][current.c]) {
						check[nr][nc] = true;
						Point nextPoint = new Point(nr,nc);
						qu.offer(nextPoint);
					}else if(isBlind) {//색약인경우
						if(mat[nr][nc] == 'R' && mat[current.r][current.c]=='G'
							|| mat[nr][nc] == 'G' && mat[current.r][current.c]=='R') {
							check[nr][nc] = true;
							Point nextPoint = new Point(nr,nc);
							qu.offer(nextPoint);
						}
					}
				}
			}
		}
	}
	
	static class Point {
		int r; 
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
}














