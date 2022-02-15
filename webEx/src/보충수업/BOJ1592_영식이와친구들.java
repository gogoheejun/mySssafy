package 보충수업;

import java.util.Queue;
import java.util.Scanner;

public class BOJ1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		int np = 0;
		int cnt = 0;
		while(arr[np] < M){
			cnt++;
			arr[np]+=1;
			if(arr[np]%2 == 1) {//홀수면
				np +=L; 
				if(np>N-1) {
					np -= N; 
				}
			}else {//짝수면
				np -=L; 
				if(np<0) {
					np = N+np;
				}
			}
		}
		System.out.println(cnt);
	}

}
