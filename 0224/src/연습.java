import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==> 21
 */

public class 연습 {
	static int N, E; 
	
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
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		int start = sc.nextInt();
		
		Node[] adjList = new Node[E];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adjList[from] = new Node(to,weight,adjList[from]);
		}
		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		PriorityQueue<Node> pq = new PriorityQueue<연습.Node>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node node =pq.poll();
			
			int current = node.vertex;
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Node temp = adjList[current]; temp!=null; temp=temp.link) {
				if(!visited[temp.vertex] && dist[temp.vertex]>dist[current]+temp.weight) {
					 dist[temp.vertex] = dist[current]+temp.weight;
					 pq.offer(new Node(temp.vertex, dist[temp.vertex]));
				}
			}
		}
		for(int i=1; i<dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}
}

















