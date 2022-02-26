package 개인연습.순열조합문제들;

import java.util.Scanner;

public class BOJ1018 {
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 행
		N = sc.nextInt();// 열

		int cnt = 0;
		char color ='B';
		char lineFirst;
		for (int i = 0; i < M; i++) {
			String line = sc.next();
			lineFirst = line.charAt(0);
			for (int j = 0; j < N; j++) {
				char now = line.charAt(j);
				if (color != now) {
					cnt++;
				}
				color = (color == 'B') ? 'W' : 'B';
			}
		}
		System.out.println(cnt);
	}
}
