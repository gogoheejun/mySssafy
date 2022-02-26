package 개인연습;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1961_최소비용구하기 {

	static class Node implements Comparable<Node>{
		int vertex;
		int cost;
		Node link;
		public Node(int vertex, int cost, Node link) {
			this.vertex = vertex;
			this.cost = cost;
			this.link = link;
		}
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", cost=" + cost + ", link=" + link + "]";
		}
	}

	static int N, M, start, end;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[] dis = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Node[] adjList = new Node[N+1];
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			adjList[from] = new Node(to, cost, adjList[from]);
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		int ans = 0;
		while(!pq.isEmpty()) {
//			System.out.println(pq);
			Node node = pq.poll();
//			System.out.println("poll: "+ node.vertex);
			ans += node.cost;
			int current = node.vertex;
			
			if(node.vertex == end) {
				break;
			}
			
			if(visited[current]) continue;
			visited[current] = true;
			
//			System.out.println("도착: "+ current);
			
			for(Node temp=adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex] && dis[temp.vertex] > dis[current]+ temp.cost) {
					dis[temp.vertex] = dis[current]+ temp.cost;
					pq.offer(new Node(temp.vertex, dis[temp.vertex]));
				}
			}
		}
		
		System.out.println(dis[end]);
		
	}
}
















