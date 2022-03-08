package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
	
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			arr = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(N, 0,0);
			System.out.println();
		}
	}
	
	
	static void combi(int N, int cnt, int start) {
		if(cnt ==6) {
			for (int i = 0; i < arr.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			combi(N, cnt+1, i+1);
			visited[i] = false;
		}
	}
}





