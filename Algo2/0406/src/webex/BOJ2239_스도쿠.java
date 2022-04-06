package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2239_스도쿠 {
	static int[][] map;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		list = new ArrayList<int[]>();
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = line.charAt(i)-'0';
				
				if(map[i][j] == 0) list.add(new int[] {i,j});
			}
		}
		
		go(0);
	}
	
	static void go(int count) {
		if(list.size() ==  count) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]);
				}
			}
			System.out.println();
			return;
		}
		
		int r = list.get(count)[0];
		int c = list.get(count)[1];
		
		boolean[] used = new boolean[10];
		//가로
		for(int i=0; i<9; i++) {
			if(map[r][i] != 0) {
				used[map[r][i]] = true;
			}
		}
		//세로
		for(int i=0; i<9; i++) {
			if(map[i][c] != 0) {
				used[map[i][c]] = true;
			}
		}
		
		int startR = (r/3)*3;
		int startC = (c/3)*3;
		for(int i=startR; i<startR+3; i++) {
			for(int j=startC; j<startC+3; j++) {
				if(map[i][j]!=0) {
					used[map[i][j]] = true;
				}
			}
		}
		
		for(int i=1; i<10; i++) {
			if(!used[i]) {//사용된 적 없다면
				System.out.println("카운트:"+count+",use:"+i);
				map[r][c] = i;
				go(count+1);
				map[r][c] = 0;
			}
		}
	}
}
















