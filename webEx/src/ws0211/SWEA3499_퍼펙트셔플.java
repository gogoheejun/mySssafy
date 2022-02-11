package ws0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			Queue<String> q1 = new LinkedList<String>(); 
			Queue<String> q2 = new LinkedList<String>(); 
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = (int)Math.ceil(1.0*N/2.0);//정수나눗셈 -> 소숫점결과 캐스팅 조심
			for(int i=0; i<n; i++) {
				q1.offer(st.nextToken());
			}
			while(st.hasMoreTokens()) q2.offer(st.nextToken());
//			System.out.println(q1);
//			System.out.println(q2);
			
			String[] ans = new String[N];
			for(int i=0; i<N; i++) {
				if(i%2 == 0) {
					ans[i] = q1.poll();
				}else {
					ans[i] = q2.poll();
				}
			}
//			System.out.println(q1);
//			System.out.println(q2);
//			System.out.println(Arrays.toString(ans));
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i=0; i<ans.length; i++) {
				sb.append(" "+ans[i]);
			}
			System.out.println(sb);
		}
	}
}
