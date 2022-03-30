package ws0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2636_치즈 {
	static int R, C;
	static int[][] mat;
	static boolean[][] check;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new int[R][C];
		check = new boolean[R][C];
		int cnt = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j]==1) cnt++;
			}
		}
		//...입력완료
		Stack<Integer> stack = new Stack<Integer>();
		int time = 0;
		int ans = 0;
		bfs();
		while(true) {
			time++;
			bfs();
			
//			System.out.println("=====================");
			ans = 0;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
//					System.out.print(mat[r][c]);
					if(mat[r][c]==1) ans++;
				}
//				System.out.println();
			}
			
			//mat돌면서 4방이 check중 true가 있으면 0으로 바꾸기
			boolean flag = false;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(mat[r][c]==0) continue;
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(check[nr][nc]==true) {
							flag = true;
							cnt--;
							mat[r][c] = 0;
						}
					}
				}
			}
			
			if(flag) {
				stack.add(ans);
//				System.out.println("카운트"+ans);
				cnt = 0;
			}else {
				break;
			}
		}//..while 끝
		
		System.out.println(time-1);
		System.out.println(stack.pop());
	}
	
	static void bfs() {
		check = new boolean[R][C];
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(0,0));//0,0은 무조건 비어었음.
		check[0][0] = true;
		while(!qu.isEmpty()) {
			Point p = qu.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				if(nr>=0 && nr<R && nc>=0 && nc<C &&mat[nr][nc]==0 && check[nr][nc]==false) {
					qu.add(new Point(nr,nc));
					check[nr][nc] = true;
				}
			}
		}
	}
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
















