package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2667_단지번호붙이기 {
	static int N;
	static int[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt=0;
	static ArrayList<Integer> cntList = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] = line.charAt(j)-48;
			}
		}

		bfs();
		System.out.println(cnt);
		Collections.sort(cntList);
		for(int i=0; i<cntList.size(); i++) {
			System.out.println(cntList.get(i));
		}
	}
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	static int bfs() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(mat[r][c] == 1) {
					mat[r][c] = 0;
//					System.out.println("r,c: "+r+", "+c);
					cnt++;
					Queue<Point> qu = new LinkedList<>();
					qu.offer(new Point(r,c));
					int cntTemp=1;
					while(!qu.isEmpty()) {
						Point p = qu.poll();
						int nowR = p.r;
						int nowC = p.c;
						for(int i=0; i<4; i++) {
							int nr = nowR+dr[i];
							int nc = nowC+dc[i];
							if(nr>=0 && nr<N && nc>=0 && nc<N && mat[nr][nc]==1 ) {
								qu.offer(new Point(nr,nc));
								mat[nr][nc] = 0;
								cntTemp++;
							}
						}
					}
					cntList.add(cntTemp);
//					System.out.println(cntTemp);
				}
			}
		}
		return cnt;
	}
}















