

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * from to weight
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

=>
0
2
3
7
INF
 */
public class BOJ_1753_정답_최단경로_인접리스트andPQ {
	static int V, E, start;

	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
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
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		int[] dist = new int[V+1];
		Node[] adjList = new Node[V+1];//1~V
		boolean[] visited = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			adjList[from] = new Node(to,w,adjList[from]);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		pQ.offer(new Node(start,0));
		
		while(!pQ.isEmpty()) {
			//dist에서 젤 가까운 애 찾기
			Node node = pQ.poll();
			int current = node.vertex;
//			if(visited[current]) continue;
//			visited[current] = true;
			
			//뽑힌 점점에 연결된 간선들 업데이트
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex] && dist[temp.vertex] > dist[current]+temp.weight) {
					dist[temp.vertex] = dist[current]+temp.weight;
					pQ.offer(new Node(temp.vertex, dist[temp.vertex]));
				}
			}
		}
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
		
	}

}






















