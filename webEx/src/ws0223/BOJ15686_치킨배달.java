package ws0223;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686_치킨배달 {

	static class Place{
		int r;
		int c;
		public Place(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] mat;
	static int cntHome, cntChicken;
	static List<Place> homes = new ArrayList<>();
	static List<Place> chickens = new ArrayList<>();
	static boolean[] isOpen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new int[N][N];
		
		cntHome = 0;
		cntChicken =0; //M이상 && 13이하
		
		for(int i=0; i<N ;i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] = sc.nextInt();
				if(mat[i][j]==1) {
					cntHome++;
					homes.add(new Place(i,j));
				}
				else if(mat[i][j]==2) {
					cntChicken ++;
					chickens.add(new Place(i,j));
				}
			}
		}
		//cntChicken중에 M개를 뽑는거임.
		isOpen = new boolean[cntChicken];
		combi(0,0);
		System.out.println(minDist);
	}
	
	static int minDist = Integer.MAX_VALUE;
	static void combi(int cnt, int start) {
		if(cnt == M) {
			//집들과의 거리
			int sum = 0;
			for(Place home : homes) {
				int tempMin = Integer.MAX_VALUE;
				for(int i=0; i<chickens.size(); i++) {
					if(!isOpen[i]) continue;
					int dist = Math.abs(home.r-chickens.get(i).r)+Math.abs(home.c-chickens.get(i).c);
					tempMin = Math.min(tempMin, dist);
				}
				sum+=tempMin;
			}
			minDist = Math.min(minDist, sum);
			return;
		}
		
		for(int i=start; i<cntChicken; i++) {
			isOpen[i] = true;
			combi(cnt+1, i+1);
			isOpen[i] = false;
		}
	}
	

}
