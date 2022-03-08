package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N, M, K;
	static int[][] mat;
	static int[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			mat = new int[N][M];
			visited = new int[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				mat[x][y] = 1;
			}//...입력끝
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(mat[i][j]==1 && visited[i][j]==0) {
						cnt++;
						dfs(i,j);
						visited[i][j] = 1;
//						System.out.println("카운트증가: "+i+", "+j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(mat[nr][nc]==1 && visited[nr][nc]==0) {
					visited[nr][nc] = 1;
					dfs(nr,nc);
				}
			}
		}
		
		
	}
}














