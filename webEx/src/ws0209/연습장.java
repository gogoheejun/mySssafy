package ws0209;

import java.io.IOException;

import java.util.Scanner;

public class 연습장 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int input[] = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		
		int before = 0;
		int now = 0;
		int cnt = 0;
		int answer = 0;
		for(int i=0; i<N; i++) {
			now = input[i];
			if(now >= before) {
				cnt++;
				if(i == N-1) {
					answer = Math.max(answer, cnt);
				}
			}else {
				answer = Math.max(answer, cnt);
				cnt = 1;
			}
			before = now;
		}
		cnt = 0;
		for(int i=0; i<N; i++) {
			now = input[i];
			if(now <= before) {
				cnt++;
				if(i == N-1) {
					answer = Math.max(answer, cnt);
				}
			}else {
				answer = Math.max(answer, cnt);
				cnt = 1;
			}
			before = now;
		}
		
		
		System.out.println(answer);
	}
}