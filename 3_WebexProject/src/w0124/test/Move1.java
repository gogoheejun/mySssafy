package w0124.test;

import java.util.Arrays;
import java.util.Scanner;

/*
이동 명령을 입력하세요(Ex: RRDDRDL) : RRD
움직인 방향 출력 : R
[true, true, false]
[false, false, false]
[false, false, false]

움직인 방향 출력 : R
[true, true, true]
[false, false, false]
[false, false, false]

움직인 방향 출력 : D
[true, true, true]
[false, false, true]
[false, false, false]
*/
public class Move1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 상하좌우
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		int dir = 0;                          // 방향을 저장할 변수
		boolean[][] map = new boolean[3][3];  // Map

		// 명령 입력, 0행 0열부터 시작
		System.out.print("이동 명령을 입력하세요(Ex: RRDDRDL) : ");
		String move = sc.nextLine();
		map[0][0] = true;
		int r = 0, c = 0;

		// 이동
		for (int i = 0; i < move.length(); i++) {
			char a = move.charAt(i);
			System.out.println("움직인 방향 출력 : " + a);
			switch (a) {
				case 'U': dir = 0; break;
				case 'D': dir = 1; break;
				case 'L': dir = 2; break;
				case 'R': dir = 3; break;
			}
			
			// 이동
			r += dy[dir];
			c += dx[dir];
			map[r][c] = true;
			
			// 현재 Map 상태 출력
			for(int j = 0; j < 3; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println();
		}
	}
}
/*
[4방 탐색:상하좌우]
int[] dy = { -1, 1, 0, 0 };
int[] dx = { 0, 0, -1, 1 };

[4방 탐색:상하좌우]
int[][] dydx = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};

[8방 탐색:12시, 1시, 3시, 5시, 6시, 7시, 9시, 11시방향]
int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1};
*/