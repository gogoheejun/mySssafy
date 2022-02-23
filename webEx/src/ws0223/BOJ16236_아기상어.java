package ws0223;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

-> 14
 */
public class BOJ16236_아기상어 {

	static int N;
	static int mat[][];
	static int[] dr = {-1,0,1,0};//상좌하우
	static int[] dc = {0,-1,0,1};//
	static int sharkSize = 2;
	static int eatCnt = 0;
	static int time = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//공간의 크기
		mat = new int[N][N];
		int startR = 0, startC=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] = sc.nextInt();
				if(mat[i][j] == 9) {
					startR = i;//2
					startC = j;//1
				}
			}
		}		
		Queue<Place> q = new LinkedList<Place>();
		q.offer(new Place(startR, startC, 0));
		while(true) {
			List<Place> fishPlaceList = new ArrayList<Place>();
			int[][] dist = new int[N][N];
			
			while(!q.isEmpty()) { 
				Place current = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = current.r + dr[i];
					int nc = current.c + dc[i];
					//일단 행렬의 접근가능한 모~든 칸 돌면서 해당하는 위치의 정보와 거리를 q에 추가
					//그러다 먹을수있는 물고기 만나면 fishQ에추가(fishQ중 가장 가까운 애는 곧 아기상어의 다음목적지임)
					//또한 dist[][]통해서 체크를 해주고 있음. 안 가본곳만 다시 가야지.
					if(nr>=0 && nc>=0 && nc<N && nr<N && dist[nr][nc]==0 &&mat[nr][nc] <= sharkSize ) {
						dist[nr][nc] = current.dist+1;
						q.add(new Place(nr, nc, dist[nr][nc]));
						if(1<=mat[nr][nc] && mat[nr][nc]<=6 && mat[nr][nc] < sharkSize) {
							fishPlaceList.add(new Place(nr,nc,dist[nr][nc]));
						}
					}
				}
				
				if(fishPlaceList.size()==0) {
					System.out.println(time);
					return;
				}
				
				//위에서 전체 다~돌면서 찾은 물고기위치정보들 중에서, 문제조건에 맞는 물고기 위치를 뽑아줌.(=>상어의 다음위치가 됨)
				Place currentFishPlace = fishPlaceList.get(0);
				for(int i=1; i<fishPlaceList.size(); i++) {
					if(currentFishPlace.dist > fishPlaceList.get(i).dist) {
						currentFishPlace = fishPlaceList.get(i);
					}
					else if(currentFishPlace.dist == fishPlaceList.get(i).dist) {
						if(currentFishPlace.r>fishPlaceList.get(i).r) currentFishPlace = fishPlaceList.get(i);
						else if(currentFishPlace.r == fishPlaceList.get(i).r) {
							if(currentFishPlace.c>fishPlaceList.get(i).c) currentFishPlace = fishPlaceList.get(i);
						}
					}
				}
				
				//이동할때 처리해줘야 할 잔처리들.
				time+= currentFishPlace.dist;
				eatCnt++;
				mat[currentFishPlace.r][currentFishPlace.c] = 0;
				if(eatCnt == sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}
				
				q.add(new Place(currentFishPlace.r, currentFishPlace.c, 0));
			}
		}
	}
	
	public static class Place{
		int r;
		int c;
		int dist;
		
		public Place(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

}
