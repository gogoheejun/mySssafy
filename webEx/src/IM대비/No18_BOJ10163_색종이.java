package IM대비;

import java.util.Scanner;

public class No18_BOJ10163_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R, C, W, H;
		int[][] mat = new int[1001][1001];
		for(int i=0; i<N; i++) {
			int cnt = 0;
			
			C = sc.nextInt();
			R = 1001-sc.nextInt()-1;
			W = sc.nextInt();
			H = sc.nextInt();
//			System.out.println(r+","+c+","+w+","+h+",");
		
			//칠하기
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					mat[R-h][C+w] = i+1;
				}
			}
					
					
			
		}
		for(int i=0; i<N; i++) {
			int cnt = 0;
			//세기
			for(int r=0; r<1001; r++) {
				for(int c=0; c<1001; c++) {
					if(mat[r][c] == i+1) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
		
	}
}
