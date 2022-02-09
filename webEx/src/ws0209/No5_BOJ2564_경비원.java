package ws0209;

import java.util.Arrays;
import java.util.Scanner;

public class No5_BOJ2564_경비원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int[][] mat = new int[H+1][W+1];
		int R = sc.nextInt();
		int[][] loc = new int[R+1][2];
		for(int i=0; i<R+1; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			if(dir == 1) {
				mat[0][dis] = i+1;
				loc[i] = new int[]{0,dis};
			}
			if(dir == 2) {
				mat[H][dis] = i+1;
				loc[i] = new int[]{H,dis};
			}
			if(dir == 3) {
				mat[dis][0] = i+1;
				loc[i] = new int[]{dis,0};
			}
			if(dir == 4) {
				mat[dis][W] = i+1;
				loc[i] = new int[]{dis,W};
			}
		}
		int[] myloc = loc[R];
		///입력끝
		for(int i=0; i<loc.length; i++) {
			System.out.println(Arrays.toString(loc[i]));
		}
		
		for(int i=0; i<loc.length-1; i++) {
			int r = loc[i][0];
			int c = loc[i][1];
			int myR = myloc[0];
			int myC = myloc[1];
			
			int routeClock = 0;
			int routeReverse = 0;
			
			//방법1
			//밑
			 
			
		}

		
		
	}
}
