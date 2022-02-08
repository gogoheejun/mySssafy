package ws0204_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15649_NM13 {

	private static int N, M;
	private static int[] selected;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];
		visited = new boolean[N];

		perm(0);

		System.out.println(sb);
	}

	private static void perm(int cnt) { // cnt : 현재까지 뽑은 순열 수의 개수
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
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
