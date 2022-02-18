package ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20 //200

1
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14 //304


 */
public class swea1247_최적경로_그래프로풀기 {
	static int N;
	static int shortestRoute;
	static boolean[] visited;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()) + 2;
			map = new int[N][N];
			int[][] xy = new int[N][2];
			visited = new boolean[N];
			
			//좌표입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				 xy[i][0] = Integer.parseInt(st.nextToken());
				 xy[i][1] = Integer.parseInt(st.nextToken());
			}
			//거리입력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int dist = Math.abs(xy[i][0]- xy[j][0])+Math.abs(xy[i][1]-xy[j][1]);
					map[i][j] = dist;
				}
			}
			
			shortestRoute = Integer.MAX_VALUE;
			visited[0] = true;
			dfs(0,1,0);
			
			sb.append("#").append(tc).append(" ").append(shortestRoute).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int from, int cnt, int dist) {
		if(from == 1) {
			if(cnt == N) {
				shortestRoute = dist;
			}
			return;
		}
		for(int i=0; i<N;i++) {
			if(!visited[i] &&map[from][i] != 0 && dist+map[from][i] < shortestRoute) {
				visited[i] = true;
				dfs(i, cnt+1, dist+map[from][i]);
				visited[i] = false;
			}
		}
	}
}















