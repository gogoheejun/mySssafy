package ws0216;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연습장 {
	static int N;
	static char[][] mat;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mat = new char[N][N];
		for(int i=0; i<N; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		sb = new StringBuilder();
		quadTree(N,0,0);
		System.out.println(sb);
	}
	
	static void quadTree(int len, int r, int c) {
		if(len == 1) {
			sb.append(mat[r][c]);
			return;
		}
		//다른지 검사
		boolean isDifferent = false;
		char first = mat[r][c];
		outer: for(int i=r; i<len+r; i++) {
			for(int j=c; j<len+c; j++) {
				if(first != mat[i][j]) {
					isDifferent = true;
					break outer;
				}
				
			}
		}
		
		if(isDifferent) {
			sb.append("(");
			quadTree(len/2, r, c);
			quadTree(len/2, r, c+len/2);
			quadTree(len/2, r+len/2, c);
			quadTree(len/2, r+len/2, c+len/2);
			sb.append(")");
		}else {
			sb.append(first);
		}
	}
}












