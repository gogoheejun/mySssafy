package ws0224;

import java.util.Arrays;
import java.util.Scanner;
/*
[입력]
5 7
1
1 2 3
1 3 6
1 4 7
2 3 1
3 4 4
3 5 2
4 5 3

[출력]
0
3
4
7
6

[입력]
5 5
1
1 2 10
1 3 5
1 4 3
2 4 2
2 5 6

[출력]
0
10
5
3
16
 */
public class BOJ_1753최단경로_인접행렬 {

	static int V, E, start;
	static int[][] mat;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		mat = new int[V+1][V+1];
		for(int i=0; i<V; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			mat[u][v] = w;
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i=0; i<E; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for(int j=1; j<V+1; j++) {
				if(!visited[j]&& min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			for(int j=1; j<V+1; j++) {
				if(!visited[j] && mat[current][j]!=0
					&& distance[j]>distance[current]+mat[current][j]) {
					
					distance[j] = distance[current]+mat[current][j];
				}
			}
			
		}
		
		for(int i=1; i<distance.length;i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}

}






















