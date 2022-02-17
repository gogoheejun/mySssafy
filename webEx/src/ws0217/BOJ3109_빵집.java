package ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {
	static int R, C;
	static char[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[R][C];
		for(int i=0; i<R; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			if(move(i,0)) ans++;
		}
		System.out.println(ans);
	}
	
	static int ans = 0;
	static boolean move(int r, int c) {
		if(c == C-1) {
			return true;
		}

		
		if(isAvailable(r-1, c+1)) {
			mat[r-1][c+1] = 'x';
			if(move(r-1,c+1)) return true;;
		}
		if(isAvailable(r, c+1)) { //else if로 했다가 틀렸음. 당장 위에거가 성공되어도 중간에 false가 날수 있기에 if로 해야 함.
			mat[r][c+1] = 'x';
			if(move(r,c+1)) return true;;
		}
		if(isAvailable(r+1, c+1)) {
			mat[r+1][c+1] = 'x';
			if(move(r+1,c+1)) return true;;
		}
		
		return false;
	}
	
	static boolean isAvailable(int r, int c) {
		if(r<0 || r>=R || mat[r][c] == 'x' ) return false;
		else return true;
	}
}











