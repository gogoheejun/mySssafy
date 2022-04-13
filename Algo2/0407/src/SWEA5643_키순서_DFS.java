import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643_키순서_DFS {

	static int[][] adjMatrix;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			//인접행렬: 0으로 자동 초기화(0: 키 관계 모름, 1: 자신보다 키가 큰 학생과의 관계를 표현)
			adjMatrix = new int[N+1][N+1];//학생번호 1부터~N까지
			
			StringTokenizer st = null;
			int a,b;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				a = Integer.parseInt(st.nextToken());//a b: a보다 b가 크다
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			
			int answer = 0;
			for(int i=1; i<=N; i++) {
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt+ltCnt == N-1) ++answer;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	static int gtCnt = 0, ltCnt=0;
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		
		for(int i=1; i<=N; i++) {//모든 학생 들여다 보면서 자신보다 키가 큰 학생따라 탐색
			if(adjMatrix[cur][i] !=0 && !visited[i]) {
				++gtCnt;
				gtDFS(i, visited);
			}
		}
	}
	
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		
		for(int i=1; i<N; i++) {
			if(adjMatrix[cur][i]!=0 && !visited[i]) {
				ltDFS(i, visited);
			}
		}
	}
}










































