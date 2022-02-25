package 보충수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA11315_오목판정 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			ans = "NO";
			N = Integer.parseInt(br.readLine());
			char[][] mat = new char[N][N];
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				mat[i] = line.toCharArray();
			}
			
			check(mat);
			
//			System.out.println(Arrays.deepToString(mat));
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	static String ans;
	static void check(char[][] mat) {
		
		//가로
		for(int i=0; i<N; i++) {
			int cnt =0;
			for(int j=0; j<N; j++) {
				if(mat[i][j] == 'o') {
					cnt++;
				}else {
					cnt = 0;
				}
			}
			if(cnt == 5) {
				ans = "YES";
				return;
			}
		}
		
		//세로
		for(int i=0; i<N; i++) {
			int cnt =0;
			for(int j=0; j<N; j++) {
				if(mat[j][i] == 'o') {
					cnt++;
				}else {
					cnt = 0;
				}
			}
			if(cnt == 5) {
				ans = "YES";
				return;
			}
		}
		
		//대각
		for(int i=0;i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(j+i>N-1) continue;
				if(mat[j+i][j] == 'o') {
					cnt++;
				}else {
					cnt = 0;
				}
			}
			if(cnt == 5) {
				ans = "YES";
				return;
			}
		}
		for(int i=0;i<N; i++) {
			int cnt = 0;
			for(int j=N-1; j>=0; j++) {
				if(j+i>N-1) continue;
				if(mat[j+i][j] == 'o') {
					cnt++;
				}else {
					cnt = 0;
				}
			}
			if(cnt == 5) {
				ans = "YES";
				return;
			}
		}
		
	}
}
