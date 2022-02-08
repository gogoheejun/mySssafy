package ws0204_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15649_NM14 {

	private static StringBuilder sb = new StringBuilder();
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		perm(0, new int[M], new boolean[N]);
		System.out.println(sb);
	}

	private static void perm(int cnt, int[] selected, boolean[] visited) { // cnt : 현재까지 뽑은 순열 수의 개수
		if (cnt == M) {
			for (int val : selected) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				selected[cnt] = i + 1;
				visited[i] = true;
				perm(cnt + 1, selected, visited);
				visited[i] = false;
			}
		}
	}
}
