package 개인연습.순열조합문제들;

import java.util.Scanner;

public class BOJ15649 {

	static int N,R;
	static int[] selected;
	static int[] numbers;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		selected = new int[N+1];
		numbers = new int[R];

		permu(0);
	}
	static void permu(int cnt) {
		if(cnt == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<N+1; i++) {
			if(selected[i] == 1) continue;
			selected[i] = 1;
			numbers[cnt] = i;
			permu(cnt+1);
			selected[i] = 0;
		}
	}

}
