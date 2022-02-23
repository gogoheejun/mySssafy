package 연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
-5개의 정점과 10개의 간선
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 */
public class 크루스칼 {
	static int N;
	static Edge[] edgeArr;
	static int[] parents;
	
	static class Edge{
		private int from;
		private int to;
		private int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int searchRoot(int a) {
		if(a == parents[a]) return a;
		return parents[a] = searchRoot(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = searchRoot(a);
		int rootB = searchRoot(b);
		if(rootA == rootB) return false;
		
		parents[rootB] = rootA;
		return true;
	}
	
	static void makeSet() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());//간선개수
		edgeArr = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeArr[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeArr);
		makeSet();
		
		int result = 0, cnt=0;
		for(Edge edge: edgeArr) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == N-1) break;
			}
		}
		System.out.println(result);
	}
}










