package webex;

import java.util.Scanner;

public class 아파트 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 2;
		for(int i=2; i<=N; i++) {
			arr[i] = arr[i-1] +arr[i-2];
		}
		System.out.println(arr[N]);
	}

}
