package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기 {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int N,M,K,X;//도시개수, 도로개수, 거리정보, 출발도시
	static int[] dist;
	static Node[] nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		nodes = new Node[N+1];//정점 n번이 무슨무슨 간선을 가지고 있는지
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(to, nodes[from]);
		}
		
		dxstra();
//		System.out.println(Arrays.toString(dist));
		boolean flag = false;
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		for(int i=1; i<N+1; i++) {
			if(dist[i] == K) {
				flag = true;
				ansList.add(i);
			}
		}
		Collections.sort(ansList);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ansList.size(); i++) {
			sb.append(ansList.get(i)).append(" ");
		}
		
		if(!flag) {
			System.out.println(-1);
		}else {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
	}
	
	static void dxstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(X);
		dist[X] = 0;
		while(!pq.isEmpty()) {
			int p = pq.poll();
			
			for(Node temp= nodes[p]; temp!=null; temp = temp.link) {
				if(dist[temp.vertex] > dist[p]+1) {
					dist[temp.vertex] = dist[p]+1;
					pq.offer(temp.vertex);
				}
			}
		}
	}
}

















