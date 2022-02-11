package IM대비;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No07_BOJ2477_참외밭 {

	public static void main(String[] args) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int fruit = sc.nextInt();

		for(int i=0; i<7; i++) {
			for(int j=0; j<2; j++) {
				int dir = sc.nextInt();
				if(dir == 1) {
					int dis = sc.nextInt();
					
					cols.add(Math.abs(dis));
				}
			}
		}
	}

}
