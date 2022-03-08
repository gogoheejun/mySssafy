package 개인연습;

import java.util.Scanner;

public class nothing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		String nums = sc.next();
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			int num = nums.charAt(i)-48;
			sum+=num;
		}
		System.out.println(sum);
	}
}
