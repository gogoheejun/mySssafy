package w0124.test;

import java.util.Scanner;

/*
[문제] 정수배열 3x3의 특정 인덱스의 8방향에 3이라는 숫자가 몇개 있는지 탐색하시오

[입력]
배열에 넣을 숫자를 입력하세요
331
203
453
1 1

[결과]
4
*/
public class Search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[3][3];
		System.out.println("배열에 넣을 숫자를 입력하세요");
		
		// int 배열에 입력된 숫자를 대입(3 * 3)
		for (int i = 0; i < 3; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 3; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 탐색할 좌표 입력
		int r = sc.nextInt();
		int c = sc.nextInt();

		// 3의 개수 파악
		int cnt = 0;
		// 12시, 1시, 3시, 5시, 6시, 7시, 9시, 11시
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		for (int i = 0; i < 8; i++) {
			if (map[r + dy[i]][c + dx[i]] == 3) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
