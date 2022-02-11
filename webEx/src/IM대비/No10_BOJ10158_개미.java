package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No10_BOJ10158_개미 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dirR = {-1,-1,1,1};//우상,좌상,우하,좌하
		int[] dirC = {1,-1,1,-1};		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		int C = Integer.parseInt(input1[0]);
		int R = Integer.parseInt(input1[1]);
		int posX =  Integer.parseInt(input2[0]);
		int posY =  Integer.parseInt(input2[1]);
		int N = Integer.parseInt(br.readLine());
		
//		int[][] mat = new int[R+1][C+1];
		
		int curR = R - posY;
		int curC = posX;
		int dir = 0;//0:우상,1:좌상,2:우하,3:좌하
		
		//...초기세팅완료
		for(int i=1; i<=N; i++) {
//			System.out.println("직전방향:"+dir);
//			System.out.println(i+" : "+curC+","+(R-curR));
			if(dir == 0) {
				//모서리에 부딪히는 경우
				if(curR+dirR[dir] == 0 && curC+dirC[dir]==C) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 3;
				}
				//위쪽벽에 부딪히는경우
				else if(curR+dirR[dir] == 0){
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 2;
				}
				//오른쪽 부딪히는 경우
				else if(curC+dirC[dir] == C) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 1;
				}else {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
				}
				
				continue;
			}
			if(dir == 1) {
				//모서리
				if(curR+dirR[dir] == 0 && curC+dirC[dir]==0) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 2;
				}
				//왼쪽벽에 부딪히는경우
				else if(curC+dirC[dir]==0) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 0;
				}
				//위쪽벽에 부딪히는 경우
				else if(curR+dirR[dir]==0) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 3;
				}
				else {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
				}
				
				continue;
			}
			if(dir == 2) {
				//모서리
				if(curR+dirR[dir] == R && curC+dirC[dir]==C) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 1;
				}
				//오른쪽벽에 부딪히는경우
				else if(curC+dirC[dir]==C) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 3;
				}
				//아래에 부딪히는 경우
				else if(curR+dirR[dir]==R) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 0;
				}else {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
				}
				
				continue;
			}
			if(dir == 3) {
				//모서리
				if(curR+dirR[dir] == R && curC+dirC[dir]==0) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 0;
				}
				//왼쪽벽에 부딪히는경우
				else if(curC+dirC[dir]==0) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 2;
				}
				//아래에 부딪히는 경우
				else if(curR+dirR[dir]==R) {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
					dir = 1;
				}
				else {
					curR = curR+dirR[dir];
					curC = curC+dirC[dir];
				}
				
				continue;
			}
		}
		StringBuilder answer = new StringBuilder();
		answer.append(curC).append(" ").append(R-curR);
//		System.out.println(curC + " "+(R-curR));
		System.out.println(answer);
	}
}
