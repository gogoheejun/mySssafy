package ws0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {
	
	static class Node{
		int x;
		int y;
		int depth;
		int k;
		
		public Node(int x, int y, int depth, int k) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.k = k;
		}
	}
	
	static int K,W,H;
	static int[][] mat;
	static int[] dx= {1,-1,0,0}, dy= {0,0,1,-1};
	static int[] hx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hy = {2,1,-1,-2,-2,-1,1,2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mat = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}//...입력완료
		
		System.out.println(bfs(0,0));
	}
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] check = new boolean[H][W][K+1];
		
		check[y][x][0] = true;
		q.add(new int[] {x,y,0,0});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0], py = pos[1];
			int chance = pos[2], move=pos[3];
			
			if(px==W-1 && py==H-1) {
				 return move;
			}
			
			//기본이동
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || ny>W-1 || ny<0 || ny>H-1) continue;
				if(check[ny][nx][chance]) continue;
				
				if(mat[ny][nx] !=1) {
					check[ny][nx][chance] = true;
					q.add(new int[] {nx,ny,chance, move+1});
				}
			}
			
			//말 찬스이동: 참스 남은 경우 8방탐색
			if(chance<K) {
				for(int i=0; i<8; i++) {
					int nx = px + hx[i];
					int ny = py + hy[i];
					
					if(nx<0 || nx>W-1 || ny<0 || ny>H-1) continue;
					if(check[ny][nx][chance+1])  continue;
					
					if(mat[ny][nx] != 1) {
						check[ny][nx][chance+1] = true;
						q.add(new int[] {nx,ny,chance+1, move+1});
					}
				}
			}
		}
		return -1;
	}
}
