package ws0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251하나로 {

	//최소신장트리
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double dist;
		
		public Edge(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int)(this.dist - o.dist);
		}
		
	}
	static void makeSet() {
		for(int i=0; i<N; i++) {
			parents[i] = i;
  		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA==rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	
	static int[] parents;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			double[] xArr = new double[N];
			double[] yArr = new double[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				xArr[i] = Double.parseDouble(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				yArr[i] = Double.parseDouble(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			//..입력끝
			
			parents = new int[N];
			
			makeSet();
			
			//모든 간선들의 길이 구해서 pq에 넣기
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					double disX = Math.pow((xArr[i]-xArr[j]), 2);
					double disY = Math.pow((yArr[i]-yArr[j]), 2);
					double dis = disX + disY;
					pq.offer(new Edge(i,j,dis));
				}
			}
			
			double cost = 0;
			while(!pq.isEmpty()) {
				Edge e =pq.poll();
				if(union(e.from, e.to)) {
					cost+= E * e.dist;
				}
			}
			Long ans = Math.round(cost);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
