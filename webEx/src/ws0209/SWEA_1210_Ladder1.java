package ws0209;

import java.io.IOException;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {

	public static void main(String[] args) throws IOException {

		//입력 이상함....계속 해맸음..
		Scanner sc = new Scanner(System.in);
		int size = 100;
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int[][] mat = new int[100][100];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
//////////////풀이 시작
			int dstC = 0;
			for(int c=0; c<size; c++) {
				if(mat[size-1][c] == 2) {
					dstC = c;
				}
			}
			
			//맨처음엔 일단 위로 올라가
			int dstR = size -2;
			int answer = 0;
			while(true) {//r이 0이 되면 정지
				
				//좌 살핌
				if(dstC-1 >0 && mat[dstR][dstC-1] == 1) {
					mat[dstR][dstC] = 0; //못돌아가게 막음
					dstC = dstC-1;
				}else if(dstC+1 <size && mat[dstR][dstC+1] == 1) {//우 살핌
					mat[dstR][dstC] = 0;
					dstC = dstC+1;
				}
				//좌우 모두 없으면
				else {
					dstR = dstR -1;
					if(dstR == 0) {
						answer = dstC;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+answer);	
		}
	}
}