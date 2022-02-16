package ws0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//직접 풀지 못하여서 인터넷블로그를 많이 참고하였습니다.(https://wiselog.tistory.com/139) 안보고 다시 풀어서 제것으로 만들도록 하겠습니다.
public class BOJ1992_쿼드트리 {

	static int N;
	static char[][] mat;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new char[N][N];
		for (int i = 0; i < N; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		
		sb = new StringBuilder();
		
		quadTree(N, 0, 0);
		System.out.println(sb);
	}
	
	private static void quadTree(int size, int r, int c) { //size와 체크할 시작 인덱스들
		if (size == 1) {
			sb.append(mat[r][c]);
			return;
		}
		
		boolean isDifferent = false;
		char first = mat[r][c];
		outer: for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(first != mat[i][j]) {
					isDifferent = true; //하나라도 숫자가 다르다면
					break outer; //2중 for문 한번에 나가기
				}
			}
		}
		
		if(isDifferent) {
			sb.append("(");
			quadTree(size/2, r, c); //1사분면 체크
			quadTree(size/2, r, c + size/2); //2사분면
			quadTree(size/2, r + size/2, c); //3사분면
			quadTree(size/2, r + size/2, c + size/2); //4사분면
			sb.append(")");
		}
		else
			sb.append(first);
	}

}