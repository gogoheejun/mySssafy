package 보충수업;

import java.util.Scanner;

//교수님 풀이
public class BOJ1592_영식이와친구들2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체인원
		int M = sc.nextInt(); // 공 최대개수
		int L = sc.nextInt(); // 건너띄기 칸수

		int[] map = new int[N]; // 모듈러 연산 0을 사용ㅇ
		int pos = 0;
		int res = 0; // 누적값 출력
		while (true) { // 실행횟수
			// 공받기
			map[pos]++;
			// 마지막 판단
			if (map[pos] == M) { // 한 사람이 공을 M번 받았으면 게임은 끝난다
				break;
			}

			// 현재 볼갯수에 따른 왼쪽, 오른쪽 이동
//	            현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게,
//	            짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
			if (map[pos] % 2 == 0) {// 짝수
				pos = (N + pos - L) % N;
			} else {
				pos = (N + pos + L) % N;
			}
			// 횟수 세기
			res++;
		}

		System.out.println(res);

	}

}
