package ws0204_1;

import java.util.Scanner;

public class Main_BOJ_15649_NM12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		perm(0, N, M, new int[M], new boolean[N]);
	}

	private static void perm(int cnt, int N, int M, int[] selected, boolean[] visited) { // cnt : 현재까지 뽑은 순열 수의 개수
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
				perm(cnt + 1, N, M, selected, visited);
				visited[i] = false;
			}
		}
	}
}
