package ws0211;

/*
[입력]
3
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2
4
8 9 10 11
5 6 7 8
1 2 3 4
13 14 15 16

[출력]
#1 1 2
#2 3 3
*/
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1861_정사각형방 {
	static int[][] a;
	static int n;
	static int[][] visit;
	static int idx;
	static int max;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void dfs(int start, int depth, int x, int y) {
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (a[nx][ny] == (a[x][y] + 1) && visit[nx][ny] == 0)
					dfs(start, depth + 1, nx, ny);
			}
		}
		if (depth > max) {
			max = depth;
			idx = start;
		}
		if (depth == max) {
			idx = Math.min(idx, start);  //동일한 방문길이를 갖는다면 적은 숫자를 선택
		}
		visit[x][y] = 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src/ws0209/input1.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			a = new int[n][n];
			visit = new int[n][n];
			idx = 0;
			max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(a[i][j], 1, i, j);
				}
			}
			System.out.println("#" + t + " " + idx + " " + max);
		}
	}
}
