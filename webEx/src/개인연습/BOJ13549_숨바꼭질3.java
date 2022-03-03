package 개인연습;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ13549_숨바꼭질3 {
	
	static class Node implements Comparable<Node>{
		int vertex;
		int cost;

		public Node(int vertex, int cost) {
			super();
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[100001];
		
		dist[N] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(N, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.vertex;
//			System.out.println(Arrays.toString(dist));
//			if(current == K) break;
			
//			if(visited[current]) continue;
//			visited[current] = true;
			
			//+1
			int next1 = current+1;
			if(next1>=0 && next1<100001
					&& dist[next1]> dist[current]+1) {
				dist[next1] = dist[current]+1;
				pq.offer(new Node(next1,1));
			}
			//-1
			int next2 = current-1;
			if( next2>=0 && next2<100001 
					&& dist[next2]> dist[current]+1) {
				dist[next2] = dist[current]+1;
				pq.offer(new Node(next2,1));
			}
			//2배
			int next3 = current*2;
			if(next3>=0 && next3<100001 
					&& dist[next3]> dist[current]) {
				dist[next3] = dist[current];
				pq.offer(new Node(next3,0));
			}
		}
		
		System.out.println(dist[K]);
		
	}
}
















