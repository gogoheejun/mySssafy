package ws0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트 {
	
	static int T, N, L;
	static int[] points, calories;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
				
		for(int tc=1; tc<=T; tc++) {

			answer =0;
			
			N = sc.nextInt();
			L = sc.nextInt();
			
			points = new int[N];
			calories = new int[N];
			
			for(int i=0; i<N; i++) {
				points[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			find(points,calories,0,0,0);
			System.out.println("#" + tc + " " + answer);
		}

		
	}
	static void find(int[] points, int[] calories,int idx, int curPoint, int curCal){
		if(curCal > L) {
			return;
		}
		if(curPoint > answer) {
			answer = curPoint;
		}
		if(idx == N) {
			return;
		}
		find(points, calories, idx+1, curPoint+points[idx], curCal+calories[idx]);
		find(points, calories, idx+1, curPoint, curCal);
	}

}
