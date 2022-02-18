package ws0218;

import java.util.Scanner;

public class BOJ15683_감시 {
	static int[][] mat;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		mat = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				mat[r][c] = sc.nextInt();
			}
		}
		
		
	}
}
