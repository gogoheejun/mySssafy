package ws0217.professor;


/*
[입력]
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20

[출력]
#1 200

*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int N;
	static int shortestRoute;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/ws0217/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= 1; tc++) {
			N = Integer.parseInt(br.readLine()) + 2; // 회사와 집까지 카운트 하기 위해 + 2
			map = new int[N][N];         // 거리
			int[][] xy = new int[N][2];  // 좌표
			visited = new boolean[N];    // 방문여부

			// 좌표 저장------------------------------------------------------
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}

			// 거리 저장------------------------------------------------------
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int dist = Math.abs(xy[i][0] - xy[j][0]) + Math.abs(xy[i][1] - xy[j][1]);

					map[i][j] = dist;
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.printf("%-7d",map[i][j]);
//				}
//				System.out.println();
//			}

			shortestRoute = Integer.MAX_VALUE;
			visited[0] = true;
			dfs(0, 1, 0);

			System.out.println("#" + tc + " " + shortestRoute);
		}
	}

	public static void dfs(int from, int cnt, int dist) {
	//	System.out.println(from+" " + cnt + " " + dist);
		if (from == 1) {    // 집에 도착한 경우
			if (cnt == N) { // 고객을 다 방문하고 도착한 경우
				if (dist < shortestRoute) {
					shortestRoute = dist;
				//	System.out.println("dist:"+shortestRoute);
				}
			} else {
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[from][i] != 0 && dist + map[from][i] < shortestRoute) {
				visited[i] = true;
				dfs(i, cnt + 1, dist + map[from][i]);
				visited[i] = false;
			}
		}
	}
}
