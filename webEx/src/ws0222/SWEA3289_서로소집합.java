package ws0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_서로소집합 {

	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			makeSet(N+1);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (flag) {
				case 0:
					union(a,b);
					break;
				case 1:
					int foundA = findSet(a);
					int foundB = findSet(b);
					if(foundA==foundB) {
						sb.append(1);
					}else {
						sb.append(0);
					}
					break;

				default:
					break;
				}
			}
			
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}
	
	static void makeSet(int N) {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
	}
	
	//a의 집합 찾기: a의 대표자 찾기
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	//a,b 두 집합 합치기
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; //대표 같으면 이미 같은집합임
		
		parents[bRoot] = aRoot;//b의 짱을 a짱 아래에 붙임(=bRoot의 부모가 aRoot이다)
		return true;
	}
}









