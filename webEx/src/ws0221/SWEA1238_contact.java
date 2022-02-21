package ws0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238_contact {

	static int N, V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());//받는 데이터 수
			V = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			int[][] mat = new int[101][101];//입력값 최댓값이 100이라서 배열로 만들어줌.
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());		
				mat[from][to] = 1;
			}
			
			
			int ans = bfs(mat,V);
			int ans2 = ans;
			sb.append("#").append(tc).append(" ").append(ans2).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int bfs(int[][] mat, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[101]; //체크배열을 boolean으로 하지 않고 int로함. 몇번째 방문한 것인지 체크하기 위함임.
		
		queue.offer(start);
		visited[start] = 1;
		
		int max = 0;
		int ans = 0;
		
		while(!queue.isEmpty()){
			int current = queue.poll();
			
			for(int i=1; i<101; i++) {
				if(visited[i]==0 && mat[current][i]!=0) {
					queue.offer(i);
					visited[i] = visited[current]+1; //다음 방문차례는 현재방문차례 다음이므로.
				}
			}
			max = visited[current];
		}
		
		for(int i=1; i<101; i++) {
			if(max == visited[i]) { //같은 방문차례가 있다면, 더 큰 값으로.
				ans = ans > i ? ans : i;
			}
		}
		return ans;
	}
}












