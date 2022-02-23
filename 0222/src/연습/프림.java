package 연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프림 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		int[][] mat = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] weights = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
			weights[i] = Integer.MAX_VALUE;
		}
		
		weights[0] = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			int vertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min>weights[j]) {
					min = weights[j];
					vertex = i;
				}
			}
			
			visited[vertex] = true;
			sum+=min;
			for(int j=0; j<N; j++) {
				if(!visited[j]&& mat[vertex][j]!=0 && mat[vertex][j]<weights[j]) {
					weights[j] = mat[vertex][j];
				}
			}
		}
		System.out.println(sum);
		
	}
}











