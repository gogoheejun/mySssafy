package 보충수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] days = new int[N];
			boolean[] isOKtoSell = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxPrice = days[N-1];
			Long sum = 0L;
			for(int i=N-2; i>=0; i--) {
				if(days[i] > maxPrice) {
					maxPrice = days[i];
					isOKtoSell[i] = true;
				}else {
					sum += maxPrice-days[i];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}

}
