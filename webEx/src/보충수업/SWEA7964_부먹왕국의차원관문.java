package 보충수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7964_부먹왕국의차원관문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] cities = new int[N];
			for(int i=0; i<N; i++) {
				cities[i] = Integer.parseInt(st.nextToken());
			}//...입력 끝
			
			int dis = 0;
			int cnt = 0;
			for(int i=0; i<cities.length; i++) {
				if(cities[i]==0) dis++;
				else {
					dis = 0;
				}
				if(dis == D) {
					cnt++;
					dis=0;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
}
