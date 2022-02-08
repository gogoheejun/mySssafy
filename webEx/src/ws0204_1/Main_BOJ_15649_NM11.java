package ws0204_1;

import java.util.Scanner;

public class Main_BOJ_15649_NM11 {
	static int M, N;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		visited = new boolean[N];

		perm(0);
	}

	private static void perm(int cnt) { // cnt : 현재까지 뽑은 순열 수의 개수
		if (cnt == M) {
			for (int i = 0; i < selected.length; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				selected[cnt] = i + 1;
				visited[i] = true;
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
