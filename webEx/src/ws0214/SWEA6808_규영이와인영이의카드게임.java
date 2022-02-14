package ws0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6808_규영이와인영이의카드게임 {

	static int[] arrA;
	static int[] arrB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		arrA = new int[9];
		arrB = new int[9];
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			for(int i=1; i<19; i++) {
				int flag = 0;
				for(int j=0; j<9; j++) {
					if(arrA[j] == i) {
						flag = 1;
					}
				}
				if(flag == 0) {
					arrB[idx] = i;
					idx++;
				}
			}//...입력완료
			
			//B의 순열구하기
			permutation(0, 0);
			
			sb.append("#").append(tc).append(" ").append(sumA).append(" ").append(sumB);
		}
		System.out.print(sb.toString());
		System.out.println();
	}
	
	static int[] numbers = new int[9];
	static int sumA, sumB;
	static int cntA, cntB;
	public static void permutation(int cnt, long flag) {
		if(cnt == 9) {
			sumA = 0;
			sumB = 0;
			for(int i=0; i<9; i++) {
				if(arrA[i]>numbers[i]) {
					sumA += arrA[i]+numbers[i];
				}else {
					sumB += arrB[i]+numbers[i];
				}
			}
			if(sumA > sumB) cntA++;
			else cntB++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if((flag & (long)1<<i) != 0) continue;
			numbers[cnt] = arrB[i];
			
			permutation(cnt+1, flag | 1<<i);
		}
	}

}
