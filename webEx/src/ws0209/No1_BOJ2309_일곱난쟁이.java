package ws0209;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
//제출완료
public class No1_BOJ2309_일곱난쟁이 {

	static int N = 9;
	static int R = 7;
	static int[] heights = new int[N];
	static int[] selected = new int[R];
	static int[] answer = new int[R];
	static int sum = 0;
	static int flag = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<N; i++) {
			heights[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(heights));
		
		combi(0,0);
		Arrays.sort(answer);
		for(int h : answer) {
//			System.out.println("답------");
//			System.out.println(Arrays.toString(selected)+"//sum: "+sum);

			System.out.println(h);
		}
	}
	public static void combi(int cnt, int start) {
		
		if(cnt == R) {
			int sum = 0;
			for(int elem : selected) {
				sum +=elem;
			}
			if(sum == 100) {
//				for(int h : selected) {
//					System.out.println("답------");
//					System.out.println(Arrays.toString(selected)+"//sum: "+sum);
//
//					System.out.println(h);
//				}
				flag = 1;
				answer = selected;
				return;
			}
//			System.out.println(Arrays.toString(selected)+"//sum: "+sum);
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(flag == 1) break;
			selected[cnt] = heights[i];
			combi(cnt+1,i+1);
		}
	}

}
