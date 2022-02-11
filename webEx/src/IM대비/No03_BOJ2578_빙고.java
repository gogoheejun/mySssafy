package IM대비;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class No03_BOJ2578_빙고 {

	static int[][] mat = new int[5][5];
	public static void main(String[] args) {
		int bingo = 0;
		Scanner sc = new Scanner(System.in);
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				mat[r][c] = sc.nextInt();
			}
		}//입력완료
		
		//칠하기
		for(int i=0; i<25; i++) {
			int num = sc.nextInt();
			boolean ch = false;
//			System.out.println("카운트: "+i+"  num:"+ num);
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(num == mat[r][c]) {
						mat[r][c] = 0;
					}
				}
			}
			
			if(check() >=3) {
				System.out.println(i+1);
				return;
			}
		}
	
	}
	public static int check() {
		int bingoCnt = 0;
		for(int r=0; r<5; r++) {
			int ok=0;
			for(int c=0; c<5; c++) {
				if(mat[r][c] ==0) {
					ok+=1;
				}
			}
			if(ok == 5) {
//				System.out.println("트루!!!!!");
				bingoCnt++;
			}
		}
		//세로
		for(int c=0; c<5; c++) {
			int ok=0;
			for(int r=0; r<5; r++) {
				
				if(mat[r][c] ==0) {
					ok+=1;
				}				
			}
			if(ok == 5) {
				bingoCnt++;
			}
		}
		
		//대각
		if(mat[0][0] == 0 &&
				mat[1][1] == 0 &&
				mat[2][2] == 0 &&
				mat[3][3] == 0 &&
				mat[4][4] == 0 ) bingoCnt++;
		
		if(mat[0][4] == 0 &&
				mat[1][3] == 0 &&
				mat[2][2] == 0 &&
				mat[3][1] == 0 &&
				mat[4][0] == 0 ) bingoCnt++;
			
		return bingoCnt;
	}
	
}
