package ws0214;

import java.util.Scanner;

public class BOJ3040_백설공주와일곱난쟁이 {

	static int[] input = new int[9];
	static int[] numbers = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			input[i] = sc.nextInt();
		}
		
		combi(0,0);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum+=numbers[i];
			}
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			numbers[cnt] = input[i];
			combi(cnt+1, i+1);
		}
	}
}
