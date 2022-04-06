package 개인연습;

import java.util.Scanner;

public class BOJ11404_플로이드 {
	
	static int N,M;
	static int[][] dist;
	private static int INF = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dist = new int[N+1][N+1];
		
		//초기화1: 자기자신은 0, 그외는 무한으로
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		//초기화2: 직접 연결되어있는 것들
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			dist[from][to] = Math.min(dist[from][to], weight);
		}
		
		floyd();
		
		 //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] >= INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}
	
	static void floyd() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
				}
			}
		}
	}

}












