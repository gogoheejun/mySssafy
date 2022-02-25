package ws0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JUNGOL1683_해밀턴순환회로 {

	static int N;
	static int[][] mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		mat = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
//		System.out.println(Arrays.deepToString(mat));
		
		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = Integer.MAX_VALUE-1;
		
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min>dist[j]) {
					
					min = dist[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			
		}
	}

}
