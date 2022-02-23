package ws0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리의개수 {

	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//마을 사람 수
			int M = Integer.parseInt(st.nextToken());// 관계의 수
			
			//처음 정점들 만들기
			makeSet(N);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			
			//부모종류 개수 세기
			int cnt = 1;
			for(int i=0; i<N+1; i++) {
				findSet(i);
			}
			Set<Integer> set = new HashSet<Integer>();
			for(int i=1; i<N+1; i++) {
				set.add(parents[i]);
			}
			int ans = set.size();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
	
	static void makeSet(int N) {
		parents = new int[N+1];
		for(int i=0; i<N+1; i++) {
			parents[i] = i;
		}
	}

}
