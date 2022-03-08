package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수 {

	static int[] dr = {-1,0,1,0,1,1,-1,-1};
	static int[] dc = {0,1,0,-1,1,-1,1,-1};
	static int[][] mat;
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
//			System.out.println("안끝나? "+w+", "+h);
			if(w==0 && h==0) break;
			mat = new int[h][w];
			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<w; c++) {
					mat[r][c] = Integer.parseInt(st.nextToken());
				}
			}//.......입력완료
			int cnt = 0;
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(mat[r][c]==1) {
						cnt++;
						mat[r][c] = 0;
						bfs(r,c,w,h);
					}
//					System.out.print(mat[r][c]);
				}
//				System.out.println();
			}
			System.out.println(cnt);
		}
		
	}
	static void bfs(int r, int c, int w, int h) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(r,c));
//		mat[r][c] = 0;
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			
			for(int i=0; i<8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr>=0 && nr<h && nc>=0 && nc<w && mat[nr][nc]==1) {
					mat[nr][nc] = 0;
					qu.offer(new Point(nr,nc));
				}
			}
		}
	}
}

















