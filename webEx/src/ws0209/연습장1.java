package ws0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 연습장1 {

	public static void main(String[] args) throws IOException {

//		int size = 10;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int tc = Integer.parseInt(br.readLine());
//		for(int i=0; i<size; i++) {
//			String line = br.readLine();
//			StringTokenizer st = new StringTokenizer(line);
//			for(int j=0; j<size; j++) {
//				mat[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}//입력끝
		
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
//				System.out.print(mat[i][j]);
//			}
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int find = 0;
			int[][] a = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			
//			
//			int dstC = 0;
//			for(int c=0; c<size; c++) {
//				if(mat[size-1][c] == 2) {
//					dstC = c;
//				}
//			}
//			
//			//맨처음엔 일단 위로 올라가
//			int dstR = size -2;
//			int answer = 0;
//			while(true) {//r이 0이 되면 정지
//				
//				//좌 살핌
//				if(dstC-1 >0 && mat[dstR][dstC-1] == 1) {
//					mat[dstR][dstC] = 0; //못돌아가게 막음
//					dstC = dstC-1;
//				}else if(dstC+1 <size && mat[dstR][dstC+1] == 1) {//우 살핌
//					mat[dstR][dstC] = 0;
//					dstC = dstC+1;
//				}
//				//좌우 모두 없으면
//				else {
//					dstR = dstR -1;
//					if(dstR == 0) {
//						answer = dstC;
//						break;
//					}
//				}
//			}
//			System.out.println("#"+t+" "+answer);	
		}
		
	}
}
