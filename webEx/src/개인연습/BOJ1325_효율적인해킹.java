package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BOJ1325_효율적인해킹 {
	
	
	static class Node{
		int to;
		Node link;
		
		public Node(int to, Node link) {
			this.to = to;
			this.link = link;
		}
	}
	
	static int N;
	static int M;
	static int[] ans;
	static Node[] adjList;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		ans = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
//			adjList[from] = new Node(to, adjList[from]);
			graph.get(from).add(to);
		}
		
		
		

		for(int i=1; i<N+1; i++) {
			int cnt=1;
			visited = new boolean[N+1];
			Queue<Integer> qu = new LinkedList<>();
			qu.add(i);
			visited[i] = true;
			while(!qu.isEmpty()) {
//				Node current = qu.poll();
//				cnt++;
//				for(Node temp = current; temp!=null; temp = temp.link) {
//					if(!visited[temp.to]) {
//						visited[temp.to] = true;
//						qu.offer(new Node(temp.to, adjList[temp.to]));
//						ans[i]++;
//					}
//				}
				
				int front = qu.poll();
				for(int value : graph.get(front)) {
					if(!visited[value]) {
						visited[value] = true;
						qu.add(value);
						ans[i]++;
					}
				}
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		int max = 0;
		for(int i=1; i<N+1; i++) {
			max = Math.max(max, ans[i]);
		}
		for(int i=1; i<N+1; i++) {
			if(max == ans[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
}


















