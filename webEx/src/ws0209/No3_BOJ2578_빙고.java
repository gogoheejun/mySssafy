package ws0209;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class No3_BOJ2578_빙고 {

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
						mat[r][c] = 100;
					}
				}
			}

		}
		//검사
		int bingcoCnt = 0;
		for(int i=0; i<25; i++) {
			if(check()) bingcoCnt++;
			
			if(bingcoCnt ==3) {
				System.out.println(i+1);
				return;
			}
		}
	}
	public static boolean check() {
		for(int r=0; r<5; r++) {
			int ok=0;
			for(int c=0; c<5; c++) {
				if(mat[r][c] ==100) {
					ok+=1;
				}
			}
			if(ok == 5) {
//				System.out.println("트루!!!!!");
				return true;
			}
			
		}
		//세로
		for(int c=0; c<5; c++) {
			int ok=0;
			for(int r=0; r<5; r++) {
				
				if(mat[r][c] ==100) {
					ok+=1;
				}				
			}
			if(ok == 5) {
				System.out.println("트루!!!!!2");
				for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) {
						System.out.print(mat[x][y]+"   ");
					}
					System.out.println();
				}//입력완료
				return true;
			}
		}
		
		//대각
		if(mat[0][0] == 100 &&
				mat[1][1] == 100 &&
				mat[2][2] == 100 &&
				mat[3][3] == 100 &&
				mat[4][4] == 100 ) return true;
		
		if(mat[0][4] == 100 &&
				mat[1][3] == 100 &&
				mat[2][2] == 100 &&
				mat[3][1] == 100 &&
				mat[4][0] == 100 ) return true;
			
		return false;
	}
	
}
