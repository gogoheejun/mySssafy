package ws0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
--------
1
6
0 37 26 52 77 20
32 0 15 26 75 16
54 33 0 79 37 90
92 10 66 0 92 3
64 7 89 89 0 21
80 49 94 68 5 0
 */
public class BOJ4012_요리사 {
	static int N;
	static int[] foods;
	static int[][] mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			foods = new int[N/2];//N은 짝수로 주어짐
			mat = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					mat[r][c] = Integer.parseInt(st.nextToken());
				}
			}//입력끝
			
			//조합 n/2개씩 나누기 nCr..r=n/2
			diff = (int)Integer.MAX_VALUE;
			combi(0, 0);
			int ans = diff;
			//각각 나눈 조합의 시너지 합 구하기
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int diff;
	static void combi(int cnt, int start) {
		if(cnt == N/2) {
			//조합1,2구하기
			int[] foods2 = new int[N/2];
			int idx = 0;
			for(int i=0; i<N; i++) {
				int flag=0;
				for(int j=0; j<N/2; j++) {
					if(foods[j] == i) flag = 1; 
				}
				if(flag == 0) foods2[idx++] = i;
			}
			//
//			System.out.println("food1: "+Arrays.toString(foods));
//			System.out.println("food2: "+Arrays.toString(foods2));
			int sum1=0, sum2 = 0;
			for(int i=0; i<N/2; i++) {//구한 두개의 조합의 시너지합
				for(int j=0; j<N/2; j++) {
					
					int r1 = foods[i];
					int c1 = foods[j];
					sum1 += mat[r1][c1]; 
					
					int r2 = foods2[i];
					int c2 = foods2[j];
					sum2 += mat[r2][c2]; 
				}
			}
			
			diff = Math.min(diff,Math.abs(sum1-sum2));
//			System.out.println("diff: "+diff);
			return ;
		}
		for(int i=start; i<N; i++) {
			foods[cnt] = i;
			combi(cnt+1,i+1);
		}
	}

	
}
