package ws0215;

import java.util.Scanner;

public class BOJ2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count5 = N/5;
		int count3 = 0;
		int ans = 0;
		while(true) {
			if((N-count5*5)%3 !=0) count5--;
			else {
				//5와 3으로 모두 나눠떨어질 때
				count3 = (N-count5*5)/3;
				ans = count3+count5;
				break;
			}
			if(count5<0) {
				ans = -1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
