package 개인연습;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1922_네트워크연결 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			pq.offer(new Edge(from, to, cost));
		}
		
		makeSet();
		int ans = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int from = edge.from;
			int to = edge.to;
			int cost = edge.cost;
			if(union(from, to)) {
				ans+=cost;
			}
		}
		System.out.println(ans);
	}
	
	static void makeSet() {
		for(int i=0; i<N+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return false;
		else {
			parents[rootB] = rootA; 
		}
		return true;
	}
	
}











