package w0124.test;

import java.util.Arrays;
import java.util.Scanner;

/*
이동 명령을 입력하세요(Ex: RRDDYDL, 바깥으로 나가면 함수 종료): RRR
움직일 방향 출력 : R
[true, true, false]
[false, false, false]
[false, false, false]

움직일 방향 출력 : R
[true, true, true]
[false, false, false]
[false, false, false]

움직일 방향 출력 : R
바깥으로 이동할 수 없습니다.
*/
public class Move2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		int dir = 0;
		boolean[][] map = new boolean[3][3];

		// 명령 입력, 0행 0열부터 시작
		System.out.print("이동 명령을 입력하세요(Ex: RRDDYDL, 바깥으로 나가면 함수 종료): ");
		String move = sc.nextLine();
		map[0][0] = true;
		int r = 0, c = 0;
		int nr, nc; // 임시로 이동할 좌표를 먼저 설정

		// 이동
		for (int i = 0; i < move.length(); i++) {
			char a = move.charAt(i);
			System.out.println("움직일 방향 출력 : " + a);
			switch (a) {
				case 'U': dir = 0; break;
				case 'D': dir = 1; break;
				case 'L': dir = 2; break;
				case 'R': dir = 3; break;
			}
			// 임시로 이동
			nr = r + dy[dir];
			nc = c + dx[dir];
			
			// 바깥으로 이동하는지 체크하는 if 제어문!!
			if (0 <= nr && nr < 3 && 0 <= nc && nc < 3) {
				r = nr;
				c = nc;
				map[r][c] = true;
			} else {
				System.out.println("바깥으로 이동할 수 없습니다.");
                sc.close();
				return;
			}
			// 현재 Map 상태 출력
			for (int j = 0; j < 3; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println();
		}
	}
}