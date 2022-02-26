package 개인연습;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ파티 {

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
	
	static int N, M, X;
	static int[] dis;
	static boolean[] visited;
	static Node[] adjList;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		
		adjList = new Node[N+1];
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			adjList[from] = new Node(to, cost, adjList[from]);
		}
		
		int[] toParty = new int[N+1];
		for(int i=1; i<N+1; i++) {
			toParty[i] = goToParty(i);
		}
		goToHome();
		
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			max = Math.max(max,dis[i] + toParty[i]);
		}
		System.out.println(max);		
	}
	static int goToParty(int start) {
		dis = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.vertex;
			
			if(current == X) break;
			
			if(visited[current]) continue;
			visited[current] = true;
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex] && dis[temp.vertex] > dis[current]+temp.cost) {
//					System.out.println("temp.cost: "+temp.cost);
					dis[temp.vertex] = dis[current]+temp.cost;
					pq.offer(new Node(temp.vertex, dis[temp.vertex]));
				}
			}
		}
		
		int max = 0;
//		System.out.println(Arrays.toString(dis));
		return dis[X];
	}
	
	static void goToHome() {
		//초기화
		dis = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));
		dis[X] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.vertex;
			
			if(visited[current]) continue;
			visited[current] = true;
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex] && dis[temp.vertex] > dis[current]+temp.cost) {
//					System.out.println("temp.cost: "+temp.cost);
					dis[temp.vertex] = dis[current]+temp.cost;
					pq.offer(new Node(temp.vertex, dis[temp.vertex]));
				}
			}
		}
		
		int max = 0;
//		System.out.println(Arrays.toString(dis));
	}
}












