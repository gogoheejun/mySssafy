package com.ssafy.pcs;

import java.util.Scanner;

public class SubSetTest {
	
	static int N,input[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0);
	}
	
	public static void generateSubset(int cnt) {//cnt: 부분집합에 고려해야 하는 원소(or 직전까지 고려한 원소 수랑 같음)
		
		if(cnt == N) { //마지막 원소까지 부분집합에 다 고려된 상황
			for(int i=0; i<input.length; i++) {
				System.out.print((isSelected[i]? input[i] : "X")+ " ");
			}
			System.out.println();
			return;
		}
		
		//현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		//현재 원소 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

}
