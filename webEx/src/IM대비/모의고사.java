package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
2
3 3
2 4
 */
public class 모의고사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			double h = Math.sqrt(1.0*(Y+X)/2);
			double a = X-h;
			double b = Y-h;
			double ans = a*b*h;
			ans = Math.round((ans*1000000))/1000000.0;
//			System.out.println(ans);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
