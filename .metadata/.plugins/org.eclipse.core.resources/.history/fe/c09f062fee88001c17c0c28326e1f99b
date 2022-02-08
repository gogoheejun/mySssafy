package com.ssafy.pcs;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {

	static int N,R; //nPr
	static int[] input,numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}	
		
		permutation(0);
	}
	
	public static void permutation(int cnt) { //cnt: 직전까지 뽑은 수 개수
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<N; i++) {
			//기존자리의 수들과 중복되는지 체크
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			//다음수 뽑으러 가기
			permutation(cnt+1);
			//다시 되돌리기
			isSelected[i] = false;
			
		}
	}

}
