package webex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4485_녹색입은애가젤다지 {
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int cost;
		public Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int[][] mat = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					mat[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dist = new int[125*125+1];
			boolean[] visited = new boolean[125*125+1];
			int dest = N*N;
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = mat[0][0];
			
			Queue<Point> pq = new PriorityQueue<Point>();
			pq.offer(new Point(0,0,mat[0][0]));
			while(!pq.isEmpty()) {
				Point point = pq.poll();
				int r = point.r;
				int c = point.c;
				
//				visited[r*N+c+1] = true;
//				if(r*N+c+1 == N*N) break;
				
				for(int i=0; i<4; i++) {
					int nr = r +dr[i];
					int nc = c +dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N 
							&& dist[nr*N+nc+1] > dist[r*N+c+1]+mat[nr][nc]) {
						dist[nr*N+nc+1] = dist[r*N+c+1]+mat[nr][nc];
						pq.offer(new Point(nr,nc,mat[nr][nc]));
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Problem ").append(++test).append(": ").append(dist[N*N]);
			System.out.println(sb);
		}
	}
}