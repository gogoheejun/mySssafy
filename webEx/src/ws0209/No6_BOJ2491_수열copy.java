package ws0209;

import java.util.Scanner;

public class No6_BOJ2491_수열copy {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int answer = 0;
		int before = 0;
		int inCnt = 0;
		
		int input[] = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			int now = input[i];
//			System.out.println(now);
			if(now >= before) {
				inCnt +=1;
			}else {
				if(inCnt > answer) {
					answer = inCnt;
				}
				inCnt = 0;
			}
			before = now;
		}
		before = 0;
		int deCnt =0;
		for(int i=0; i<N; i++) {
			int now = input[i];
//			System.out.println(now);
			if(now <= before) {
				deCnt +=1;
			}else {
				if(deCnt > answer) {
					answer = deCnt;
				}
				deCnt = 0;
			}
			before = now;
		}
		System.out.println(answer);
	}
}
