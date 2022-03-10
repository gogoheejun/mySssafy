package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ4386_종이의개수 {
	static int N;
	static int[][] mat;
	static HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(N, 0,0);
		for(int i=-1; i<2; i++) {
			System.out.println(countMap.getOrDefault(i, 0));
		}
	}
	
	static void check(int size, int r, int c) {
		
		
		boolean isDifferent = false;
		int first = mat[r][c];
		
		outer: for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(first!=mat[i][j]) {
					isDifferent = true;
					break outer;
				}
			}
		}
		
		if(isDifferent) {
			int newSize = size/3;
			check(newSize,r,c);
			check(newSize,r,c+newSize);
			check(newSize,r,c+2*newSize); //..위쪽
			
			check(newSize,r+newSize,c);
			check(newSize,r+newSize,c+newSize);
			check(newSize,r+newSize,c+newSize*2);//...중간
			
			check(newSize,r+newSize*2,c);
			check(newSize,r+newSize*2,c+newSize);
			check(newSize,r+newSize*2,c+newSize*2);//..아래
		}else {
			countMap.put(first, countMap.getOrDefault(first, 0)+1);
			if(size==1) return; //size가 1이면 isDifferent는 무조건 false일것이므로 걍 여기서 처리했음
		}
	}
}



















