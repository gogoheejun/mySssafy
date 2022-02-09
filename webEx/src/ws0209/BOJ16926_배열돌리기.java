package ws0209;

import java.io.IOException;

import java.util.Scanner;
/*
 * 입력
 * 4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
출력
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
 */

//https://www.acmicpc.net/problem/16926
public class BOJ16926_배열돌리기{
	static int N, M, R; //열,행,회전수
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}//입력 끝
		
		int count = Math.min(N, M) / 2; 
		for(int i=0; i<R; i++) { 
			
			for(int j=0; j<count; j++) { 
				int temp = arr[j][j]; 
				
				for(int k=j+1; k<M-j; k++)
					arr[j][k-1] = arr[j][k];
				
				for(int k=j+1; k<N-j; k++)
					arr[k-1][M-1-j] = arr[k][M-1-j];
				
				for(int k=M-2-j; k>=j; k--)
					arr[N-1-j][k+1] = arr[N-1-j][k];
				
				for(int k=N-2-j; k>=j; k--)
					arr[k+1][j] = arr[k][j];
				
				arr[j+1][j] = temp;
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}
}