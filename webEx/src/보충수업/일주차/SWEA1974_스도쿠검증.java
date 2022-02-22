package 보충수업.일주차;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA1974_스도쿠검증 {
	static int[][] map = new int[9][9];
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			

			//만약 입력값이 띄어쓰기 없이 주어지는 경우
//			for(int i=0; i<9; i++) {
//				String s= sc.next();
//				for(int j=0; j<9; j++) {
//					map[i][j] = s.charAt(j)-'0';//-48
//				}
//			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}//입력완료
			res = 1;
			//스도쿠 검증
			check();
			System.out.println("#" + t + " " + res);
		}
	}
	
	static void check() {
		Set<Integer> set = new HashSet<>();
		//행 검증
		for(int i=0; i<9; i++) {
			set.clear();
			for(int j=0; j<9; j++) {
				set.add(map[i][j]);
			}
			if(set.size() != 9) {
				res = 0;
				return;
			}
		}
		
		//열 검증
		for(int i=0; i<9; i++) {
			set.clear();
			for(int j=0; j<9; j++) {
				set.add(map[j][i]);
			}
			if(set.size() != 9) {
				res = 0;
				return;
			}
		}
		
		//작은 사각형 검증
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				set.clear();
				for(int k=i*3; k<i*3+3; k++) {
					for(int l=j*3; l<j*3+3; l++) {
						set.add(map[k][l]);
					}
				}
				if(set.size() != 9) {
					res = 0;
					return;
				}
			}
		}
		
		
	}

}
