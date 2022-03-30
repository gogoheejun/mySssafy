package ws0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		
	}
}
