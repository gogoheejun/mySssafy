package ws0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int[] dirR = {-1,0,1,0};//위오아왼
	static int[] dirC = {0,1,0,-1};
	static int SIZE;
	static int[][] mat;
	
	static int cnt;
	static int ansCnt;
	static int ansRoom;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for (int tc = 1; tc <= T; tc++) {
			cnt = 1;
			ansCnt = 0;
			ansRoom = Integer.MAX_VALUE;
			
			SIZE = Integer.parseInt(br.readLine());
			mat = new int[SIZE][SIZE];
			for(int r=0; r<SIZE; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<SIZE; c++) {
					mat[r][c] = Integer.parseInt(st.nextToken());
				}
			}//...입력완료
			
			//로직
			for(int r=0; r<SIZE; r++) {
				for(int c=0; c<SIZE; c++) {
					dfs(r,c, mat[r][c]);
				}
			}
			sb.append("#").append(tc).append(" ").append(ansRoom).append(" ").append(ansCnt).append("\n");
		}

		System.out.print(sb);
		sb.setLength(0);
	}
	
	public static void dfs(int curR, int curC, int startRoom) {
		if(cnt >= ansCnt) {
			if(cnt>ansCnt) ansRoom = Integer.MAX_VALUE;
			ansCnt = cnt;
			ansRoom = Math.min(startRoom, ansRoom);
//			System.out.println("ansRoom: "+ansRoom);
		}
		ansCnt = Math.max(ansCnt,cnt);
		for(int i=0; i<4; i++) {
			if(curR+dirR[i]>=0 && curR+dirR[i]<SIZE && curC+dirC[i]>=0 && curC+dirC[i]<SIZE) {

				if( mat[curR+dirR[i]][curC+dirC[i]] == (mat[curR][curC]+1)) {
					cnt++;
					dfs(curR+dirR[i],curC+dirC[i],startRoom);
					cnt--;
				}
			}
		}
	}
}














