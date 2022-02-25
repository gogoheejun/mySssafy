package ws0224;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753최단경로_인접리스트 {
//시간초과뜸...
	static int V, E, start;

	static class Node {
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
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
		
		for(int i=0; i<V; i++) {//V번반복
			//dist에서 젤 가까운 애 찾기
			int min = Integer.MAX_VALUE;
			int current = 0;
			for(int j=1; j<V+1; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					current = j;
				}
			}
			visited[current] = true;
			
			//뽑힌 점점에 연결된 간선들 업데이트
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex] && dist[temp.vertex] > dist[current]+temp.weight) {
					dist[temp.vertex] = dist[current]+temp.weight;
				}
			}
		}
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
		
	}

}






















