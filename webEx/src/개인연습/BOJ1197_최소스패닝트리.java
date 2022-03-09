package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리 {
	
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
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		
	}
	static int V, E;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[E];
		parents = new int[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, cost);
		}
		Arrays.sort(edgeList);
		int ans = 0;
		int cnt = 0;
		makeSet();
		for(Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
//				System.out.println("후: from: "+edge.from+", to: "+edge.to+", cost: "+edge.cost);
				ans += edge.cost;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(ans);
	}
	
	static void makeSet() {
		for(int i=1; i<V+1; i++) {
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



























