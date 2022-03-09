package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ9370_미확인도착지 {
	
	static class Node implements Comparable<Node>{
		int vertex;
		int cost;
		Node link;
		
		public Node(int vertex, int cost, Node link) {
			this.vertex =vertex;
			this.cost = cost;
			this.link = link;
		}
		
		public Node(int vertex, int cost) {
			this.vertex =vertex;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int n,m,t , s,g,h;
	static Node[] adjList;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			adjList = new Node[n+1];
			dist = new int[n+1];
			visited = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				if((from==g && to ==h) || (from==h && to==g)) {
					cost = 2*cost-1;//홀수만들기
				}else {
					cost = 2*cost;//짝수만들기
				}
				
				adjList[from] = new Node(to, cost, adjList[from]);
				adjList[to] = new Node(from, cost, adjList[to]);
				
			}//...정점,간선정보 입력완료
			
			Arrays.fill(dist,Integer.MAX_VALUE/2 * 2);//무한대도 홀수라서 짝수로 만들어줘야 함.
			dist[s] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(s,0));
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int current = node.vertex;
				
				for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
					if(dist[temp.vertex] > dist[current]+temp.cost) {
						dist[temp.vertex] = dist[current]+temp.cost;
						pq.offer(new Node(temp.vertex, dist[temp.vertex]));
					}
				}
			}
			
			//목적지후보들 검사
			ArrayList<Integer> ansList = new ArrayList<Integer>();
			for(int i=0; i<t;i++){
				int dest = Integer.parseInt(br.readLine());
				if(dist[dest]%2 == 1) {
					ansList.add(dest);
				}
			}
			Collections.sort(ansList);
			for(int i=0; i<ansList.size(); i++) {
				sb.append(ansList.get(i)).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
}























