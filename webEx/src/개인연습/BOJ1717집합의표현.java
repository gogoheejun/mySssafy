package 개인연습;

import java.util.Scanner;

public class BOJ1717집합의표현 {
	
	static void makeSet() {
		for(int i=0; i<N+1; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean check(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA != rootB) {
			return false;
		}
		else return true;
	}
	
	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
		}
	}
	
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		makeSet();
		for(int i=0; i<M; i++) {
			int flag = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			switch (flag) {
			case 0:
				union(a, b);
				break;
			case 1:
				if(check(a, b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				
				break;

			}
		
		}
	}
}
