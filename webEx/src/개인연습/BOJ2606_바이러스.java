package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2606_바이러스 {
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		
		makeSet();
		StringTokenizer st = null;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to);
		}
		

		int cnt=0;
//		for(int i=2; i<=N; i++) {
//			findSet(i);
//		}
		for(int i=2; i<=N; i++) {
			if(findSet(i)==findSet(1)) cnt++;
		}
//		System.out.println(Arrays.toString(parents));
		System.out.println(cnt);
	}

	static void makeSet() {
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	
}
















