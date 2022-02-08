package com.ssafy.pcs;

import java.util.Scanner;

public class 연습 {
	
	static int N,R; //N:입력할숫자 개수, R:뽑을 숫자 개수
	static int[] input, numbers; //input:N개의 입력숫자들, numbers:R개의 뽑은 숫자들
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[R];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
		
	}
	public static void permutation(int cnt) {
		
		if(cnt == R) {
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
