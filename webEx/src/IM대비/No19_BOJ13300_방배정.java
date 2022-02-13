package IM대비;

import java.util.Scanner;

public class No19_BOJ13300_방배정 {
	public static void main(String[] args) {
		int[][] students = new int[7][2];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			students[grade][sex] = students[grade][sex]+1;
		}//..입력끝
//		System.out.println("-----------------");
		int cnt=0;
		for(int i=1; i<7; i++) {
			for(int j=0; j<2; j++) {
//				System.out.print(students[i][j]);
				if(students[i][j] == 0) continue;
				if(students[i][j]%K == 0) {
					cnt += students[i][j]/K;
				}else {
					cnt += (students[i][j]/K +1);
				}
			}
//			System.out.println();
		}
		System.out.println(cnt);
	}
}
