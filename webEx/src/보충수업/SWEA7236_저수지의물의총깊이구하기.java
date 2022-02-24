package 보충수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7236_저수지의물의총깊이구하기 {

	static int[] dr = {0,1,1,1,0,-1,-1,-1};//우,우하,하,좌하,좌,좌상,상,우상
	static int[] dc = {1,1,0,-1,-1,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] mat = new char[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					mat[i][j] = st.nextToken().charAt(0);
				}
			}
			//
			int ans=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
//					System.out.println("==========="+r+", "+c);
					if(mat[r][c] == 'G') continue;
					int cnt = 0;
					for(int i=0; i<8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr>=0 && nr<N && nc>=0 && nc<N && mat[nr][nc] =='W') {
//							System.out.println(nr+", "+nc);
							cnt++;
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

}
