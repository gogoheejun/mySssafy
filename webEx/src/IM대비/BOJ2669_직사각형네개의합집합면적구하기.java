package IM대비;

import java.util.Scanner;

public class BOJ2669_직사각형네개의합집합면적구하기 {

	static int[][] mat = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			int c1 = sc.nextInt();
			int r1 = 100-sc.nextInt();
			
			int c2 = sc.nextInt();
			int r2 = 100-sc.nextInt();
			
			for(int r=r2; r<r1; r++) {
				for(int c=c1; c<c2; c++) {
					mat[r][c] = 1;
				}
			}
		}
		int cnt = 0;
		for(int r=0; r<101; r++) {
			for(int c=0; c<101; c++) {
				if(mat[r][c] == 1) cnt++;
//				System.out.print(mat[r][c]);
			}
//			System.out.println();
		}
		System.out.println(cnt);
	}
}
