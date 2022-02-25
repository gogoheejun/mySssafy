package ws0224;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1504_특정한최단경로 {
	
	
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link + "]";
		}
		
	}
	
	static int N, E;
	static Node[] adjList;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new Node[N+1];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight= sc.nextInt();
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		
		int ans1 = getPath(1,v1);
		int ans2 = getPath(v1,v2);
		int ans3 = getPath(v2,N);
		int sum1 = -1;
		if(ans1 == Integer.MAX_VALUE || ans2 == Integer.MAX_VALUE || ans3 == Integer.MAX_VALUE) {
			sum1 = -1;
		}else sum1 =  ans1+ans2+ans3;
//		System.out.println(sum1);
		
		int ans11 = getPath(1,v2);
		int ans22 = getPath(v2,v1);
		int ans33 = getPath(v1,N);
		int sum2 = -1;
		if(ans11 == Integer.MAX_VALUE || ans22 == Integer.MAX_VALUE || ans33 == Integer.MAX_VALUE) {
			sum2 = -1;
		}else sum2 =  ans11+ans22+ans33;
//		System.out.println(sum2);

		int ans = 0;
		if(sum1 == -1 && sum2 == -1) {
			ans = -1;
		}
		else if (sum1 == -1 || sum2==-1) {
			ans = Math.max(sum1,sum2);
		}
		else ans = Math.min(sum1,sum2);
		System.out.println(ans);
	}
	
	static int getPath(int from, int to) {
		dist = new int[N+1];
		visited = new boolean[N+1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[from] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.vertex;
			if(visited[current]) continue;
			visited[current] = true;
//			
			if(to == current) break;
			
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
//				System.out.println("temp: "+temp.vertex);
				if( !visited[temp.vertex] && dist[temp.vertex] > dist[current]+temp.weight) {
					dist[temp.vertex] = dist[current]+temp.weight;
					pq.offer(new Node(temp.vertex, dist[temp.vertex]));
				}
			}
		}
		return dist[to];
	}
}


























