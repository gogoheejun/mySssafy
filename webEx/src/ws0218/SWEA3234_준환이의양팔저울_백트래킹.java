package ws0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1
9
1 2 3 5 6 4 7 8 9
 */
public class SWEA3234_준환이의양팔저울_백트래킹 {
	static int[] weights;
	static boolean[] selected;
	static int N;
	static int sum;
	static int[] factorial = new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		factorial[1] = 1;
		for(int i=2; i<10; i++) {
			factorial[i] = i*factorial[i-1];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());//추의 개수
			selected = new boolean[N];
			weights = new int[N];
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for(int i=0; i<N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
				sum+=weights[i];
			}
			
			pick(0,0,0);
			int ans2 = ans;
			ans =0;
			sb.append("#").append(tc).append(" ").append(ans2).append("\n");
		}
		System.out.print(sb.toString());
	}

	static int ans=0;
	static void pick(int cnt, int left, int right) {
//		if(left < right) return;

		if(cnt == N) {
			ans++;
			return;
		}
		int remain = sum - left -right;
		if(left >= remain+right) {
			ans+= factorial[N-cnt]*(1<<N-cnt);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i] == false) {
				selected[i] = true;
				pick(cnt+1, left+weights[i], right);
				
				
				if(left>=right+weights[i]) {
					pick(cnt+1,left, right+weights[i]);
				}
				
				selected[i] = false;
			}			
 		}
	}
	
}
