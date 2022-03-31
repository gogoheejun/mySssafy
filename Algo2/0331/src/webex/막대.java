package webex;

import java.util.Scanner;

public class 막대 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 5;
		arr[3] = 12;
		for(int i=2; i<=N; i++) {
			// 구하려는 길이 -1에서 한 번에 올리는 경우는 1cm막대 두 경우
            // 구하려는 길이 -2에서 한 번에 올리는 경우는 2cm막대 한 경우
			arr[i] = arr[i-1]*2 +arr[i-2];
		}
		System.out.println(arr[N]);
	}

}
