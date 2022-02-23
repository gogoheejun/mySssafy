package ws0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_아기상어_풀이 {
	
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N;
	static int[][] map;
	
	// 상어 크기, 먹은횟수, 시간을 저장할 변수 선언
	static int shark_size = 2, cnt = 0, time = 0;
	
	// 상어의 위치를 이용해 탐색하기 위해 큐 선언
	static Queue<Fish> shark_pos = new LinkedList<>();
	
	// 먹이의 정보를 저장하는 우선순위 큐 거리가 같으면 윗부분 행의 정보가 같으면 왼쪽우선으로
	static PriorityQueue<Fish> fishes = new PriorityQueue<>(new Comparator<Fish>() {
		@Override
		public int compare(Fish o1, Fish o2) {
			if(o1.distance == o2.distance) {
				return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
			}
			return o1.distance - o2.distance;
		}	
	});
	
	// 상어, 물고기 정보를 저장하는 객체 선언
	static class Fish{
		public int x, y;
		public int distance;
		
		public Fish(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark_pos.offer(new Fish(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		
		solve();
		System.out.println(time);
	}
	
	private static void solve() {
		while(true) {
			// 방문 유무 확인하기 위해
			boolean[][] isVisited = new boolean[N][N];
			
			// 상어 위치에서 상하좌우로 움직이면서 탐색
			while(!shark_pos.isEmpty()) {
				// 상어 위치정보 하나를 꺼낸다
				Fish cur = shark_pos.poll();
				isVisited[cur.x][cur.y] = true;
				
				// 먹을수 있는게 있으면 우선순위 큐와 상어 위치 큐에 위치정보 추가
				// 크기가 같아서 못 먹거나 먹이가 없으면 이동만 가능하므로 상어 위치 큐만 추가
				int idx = 0;
				while(idx < 4){
					int nx = cur.x + dx[idx];
					int ny = cur.y + dy[idx++];
					
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && !isVisited[nx][ny]) {
						if(map[nx][ny] != 0) {
							if(map[nx][ny] < shark_size) {
								fishes.offer(new Fish(nx, ny, cur.distance+1));
								shark_pos.offer(new Fish(nx, ny, cur.distance+1));
								isVisited[nx][ny] = true;
							}
							else if(map[nx][ny] == shark_size) {
								shark_pos.offer(new Fish(nx, ny, cur.distance+1));
								isVisited[nx][ny] = true;
							}
						}
						else if(map[nx][ny] == 0) {
							shark_pos.offer(new Fish(nx, ny, cur.distance+1));
							isVisited[nx][ny] = true;
						}
						
					}
				}
				
			}
			
			// 우선순위 큐가 비어있지 않으면 먹는다
			if(!fishes.isEmpty()) {
				Fish fish = fishes.poll();
				
				// 먹은 횟수와 상어의 크기가 같으면 크기를 1 증가
				if(++cnt == shark_size) {
					shark_size++;
					cnt = 0;
				}
				
				//크기가 커지면서 먹을수 있는 먹이가 확장되고 위치를 이동했으니 남은 큐비우고 현재위치 추가
				shark_pos.clear();
				shark_pos.offer(new Fish(fish.x, fish.y, 0));
				
			
				map[fish.x][fish.y] = 0;
				time += fish.distance;
				
				// 먹이를 먹음으로 상어가 위치 이동을 했으므로 우선순위 큐를 비우고 다시 탐색
				fishes.clear();
			}
			else {
				break;
			}
		
		}
		
	}

}