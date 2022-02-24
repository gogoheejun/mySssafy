package ws0223;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어다시 {
	
	static int N;
	static int[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};//상우하좌
	static int sharkSize=2;
	static int result, eatCnt;
	
	static class Place{
		int r;
		int c;
		int dist;
		public Place(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
//		@Override
//		public int compareTo(Place o) {
//			if(this.dist == o.dist) {
//				return (this.r-o.r == 0)? this.c-o.c:this.r-o.r;
//			}
//			return this.dist - o.dist;
//		}
		@Override
		public String toString() {
			return "Place [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		mat = new int[N][N];
//		visited = new boolean[N][N];
		
		int sharkR=0, sharkC=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] = sc.nextInt();
				if(mat[i][j]==9) {
					sharkR = i;
					sharkC = j;
				}
			}
		}
		mat[sharkR][sharkC] = 0;//처음에 이거 안넣어서 디버깅 1시간넘게 함..
		bfs(sharkR, sharkC);
		System.out.println(result);
	}	
	
	static void bfs(int r, int c) {
		Queue<Place> sharkPlaceQ = new LinkedList<Place>(); 
		Place shark = new Place(r,c,0);
		sharkPlaceQ.offer(shark);
		
		PriorityQueue<Place> fishQu = new PriorityQueue<>(new Comparator<Place>() {
			@Override
			public int compare(Place o1, Place o2) {
				if(o1.dist == o2.dist) {
					return (o1.r==o2.r)? o1.c-o2.c:o1.r-o2.r;
				}
				return o1.dist - o2.dist;
			}
		});
		
		while(true) {
			boolean[][] visited = new boolean[N][N];
			
			while(!sharkPlaceQ.isEmpty()) {
				Place current = sharkPlaceQ.poll();
				visited[current.r][current.c] = true;
				
				//bfs로 물고기들 거리를 구하면서 우선순위큐에 넣기
				for(int i=0; i<4; i++) {
					int nr = current.r + dr[i];
					int nc = current.c + dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
						if(mat[nr][nc] == 0) {
							sharkPlaceQ.offer(new Place(nr,nc,current.dist+1));
							visited[nr][nc] = true;
						}
						else {
							if(mat[nr][nc] < sharkSize ) {
								visited[nr][nc] = true;
								sharkPlaceQ.offer(new Place(nr,nc,current.dist+1));
								fishQu.offer(new Place(nr,nc,current.dist+1));
							}
							else if(mat[nr][nc] == sharkSize) {
								visited[nr][nc] = true;
								sharkPlaceQ.offer(new Place(nr,nc,current.dist+1));
							}
						}
					}
				}
			}
			//선정된 물고기 먹으러 이동
			if(!fishQu.isEmpty()) {
				if(++eatCnt == sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}	
//				System.out.println(fishQu);
				Place nextSharkPlace = fishQu.poll();
//				System.out.println("상어이동장소: "+nextSharkPlace.r+", "+nextSharkPlace.c);
				mat[nextSharkPlace.r][nextSharkPlace.c] = 0;
				fishQu.clear();
							
				result+=nextSharkPlace.dist;
				sharkPlaceQ.offer(new Place(nextSharkPlace.r, nextSharkPlace.c, 0));
			}else {
				return;
			}	
		}	
	}
}











