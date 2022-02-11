package IM대비;

import java.util.Arrays;
import java.util.Scanner;
//제출완료
public class No04_BOJ2563_색종이 {

	static int[][] paper = new int[100][100];
	static int N;
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					paper[100-y-10+j][x+k] = 1;
				}
				
			}
		}
		int ans =0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
//				System.out.print(paper[r][c]);
				if (paper[r][c] ==1) {
					ans++;
				}
			}
//			System.out.println();
		}
//		System.out.println(Arrays.toString(paper));
		System.out.println(ans);
		
	}
	
}
