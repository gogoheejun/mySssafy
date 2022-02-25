package ws0225;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17144_미세먼지안녕 {
	
	static class Point{
		int r;
		int c;
		int val;
		public Point(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}

	static int R, C, T;
	static int[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};//상우하좌
	static Queue<Point> qu = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		mat = new int[R][C];
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C;c++) {
				mat[r][c] = sc.nextInt();
				if(mat[r][c] >=5) {//어차피 5미만은 확산안됨
					qu.offer(new Point(r,c, mat[r][c]));
				}
			}
		}
		
		move();
		
		System.out.println("==============");
		for(int r=0; r<R; r++) {
			for(int c=0; c<C;c++) {
				System.out.print(mat[r][c]+" ");
			}
			System.out.println();
		}

	}
	
	static void move() {
		
		int time=0;
		while(!qu.isEmpty()) {
			int len = qu.size();
			time++;
			//퍼지기
			for(int t=0; t<len; t++) {
				Point p = qu.poll();
				int spreadCnt = 0;
				for(int i=0; i<4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(nr>=0 && nr<R && nc>=0 && nc<C) {
						if(mat[nr][nc] ==-1) continue;
						mat[nr][nc] += p.val/5;
						spreadCnt++;
					}
				}
				mat[p.r][p.c] -= p.val/5 * spreadCnt;
			}
			
			//순환하기
			//r=0,2..r=3,R-1일때
			//0,0 0,1...0,C-1, 1C-1
			
			//=====위쪽
//			int mat00 = mat[0][0];
//			int mat20 = mat[2][0];
//			int mat2C = mat[2][C-1];
//			int mat0C = mat[0][C-1];
//			//위
//			for(int c=0; c<C-1; c++) {
//				mat[0][c] = mat[0][c+1];
//			}
//			//왼
//			mat[2][0] = 0;
//			mat[1][0] = mat00;
//			//아래
//			for(int c=C-1; c>=1; c--) {
//				mat[2][c] = mat[2][c-1];
//			}
//			//오른
//			mat[0][C-1]=mat[1][C-1];
//			mat[1][C-1]=mat2C;
			
			//=====아래쪽
//			int mat3C = mat[3][C-1];
//			int matRC = mat[R-1][C-1];
//			int matR0 = mat[R-1][0];
//			
//			//위
//			mat[3][0] = 0;
//			for(int c=C-1; c>=1; c--) {
//				mat[3][c] = mat[3][c-1];
//			}
//			
//			//오른
//			mat[4][C-1] =  mat3C;
//			for(int r=R-1; r>=5; r--) {
//				mat[r][C-1] = mat[r-1][C-1];
//			}
//			//아래
//			mat[R-1][C-1] = matRC;
//			for(int c=0; c<C-1; c++) {
//				mat[R-1][c] = mat[R-1][c+1];
//			}
//			//왼
//			mat[R-1][0] = matR0;
//			for(int r=3; r<R-1; r++) {
//				mat[r][0] = mat[r+1][0];
//			}
//			mat[3][0] = 0;
		}
	}

}
