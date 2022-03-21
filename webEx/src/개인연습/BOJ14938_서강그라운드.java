package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14938_서강그라운드 {
	
	static class Node{
		int vertex;
		int cost;
		Node link;
		
		public Node(int vertex, int cost, Node link) {
			this.vertex = vertex;
			this.cost = cost;
			this.link = link;
		}
		
		public Node(int vertex, int cost ) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}

	static int N, M, R;
	static int[] wayNums;
	static int[] dist;
	static Node[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		wayNums = new int[N+1];
		dist = new int[N+1];
		adjList = new Node[N+1];
		visited = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			wayNums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,cost, adjList[from]);
			adjList[to] = new Node(from,cost, adjList[to]);
		}
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			dxstra(i);
			int sum = 0;
			for(int j=1; j<dist.length; j++) {
				if(dist[j]<=M) {
					sum+=wayNums[j];
				}
			}
			max = Math.max(max,sum);
		}
		
//		dxstra(1);
		System.out.println(max);
	}
	
	static void dxstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.vertex;
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if( dist[temp.vertex] > dist[current]+temp.cost) {
					dist[temp.vertex] = dist[current]+temp.cost;
					pq.offer(new Node(temp.vertex,dist[temp.vertex]));
				}
			}
		}
		
	}

}















