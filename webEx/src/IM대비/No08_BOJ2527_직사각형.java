package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No08_BOJ2527_직사각형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] answer = new char[4];
		for (int i = 0; i < 4; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			char result = 'a';

			// 안겹칠때
			if (q1 < y2 || q2 < y1 || x1 > p2 || p1 < x2) {
				result = 'd';
			}
			// 점 or 선...4개의 면 검사
			else if (p1 == x2) {
				result = (q1 == y2 || y1 == q2) ? 'c' : 'b';
			} else if (x1 == p2) {
				result = (y1 == q2 || q1 == y2) ? 'c' : 'b';
			} else if (q1 == y2) {
				result = (p1 == x2 || p2 == x1) ? 'c' : 'b';
			} else if (q2 == y1) {
				result = (p1 == x2 || p2 == x1) ? 'c' : 'b';
			} 
			System.out.println(result);
			
		}
	}
}
