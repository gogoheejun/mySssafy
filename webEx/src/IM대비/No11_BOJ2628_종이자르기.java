package IM대비;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No11_BOJ2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] mat = new int[R][C];
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> cols = new ArrayList<Integer>();
		rows.add(0);
		cols.add(0);
		for(int i=0; i<N; i++) {
			int dir = sc.nextInt();
			int idx = sc.nextInt();
			if(dir==0) {//R
				rows.add(idx);				
			}
			if(dir==1) {//C
				cols.add(idx);
			}
		}
		rows.add(R);
		cols.add(C);
		
		Collections.sort(rows);
		Collections.sort(cols);
		
		int bigRow = 0;
		int bigCol = 0;
		
		for(int i=0; i<rows.size()-1; i++) {
			int len = rows.get(i+1)- rows.get(i);
			bigRow = Math.max(len, bigRow);
		}
		for(int i=0; i<cols.size()-1; i++) {
			int len = cols.get(i+1)- cols.get(i);
			bigCol = Math.max(len, bigCol);
		}
		System.out.println(bigRow*bigCol);
	}
}
