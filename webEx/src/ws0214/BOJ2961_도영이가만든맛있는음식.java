package ws0214;

import java.util.Scanner;

public class BOJ2961_도영이가만든맛있는음식 {
	static int[] arr1;
	static int[] arr2;
	static int[] selected;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr1 = new int[N];
		arr2 = new int[N];
		selected = new int[N];
		for(int i=0; i<N; i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}//...입력끝
		subset(0);
		System.out.println(ans);
	}
	static int a = 1;
	static int b = 0;
	static int ans = Integer.MAX_VALUE;
	public static void subset(int cnt) {
		if(cnt == N) {
			int flag = 0;
			for(int i=0; i<N; i++) {
				if(selected[i] == 1) {
					flag = 1;
//					System.out.println(arr1[i]+ "  "+arr2[i]);
					a*=arr1[i];
					b+=arr2[i];
//					System.out.println(a+"//"+b);
				}
			}
			if(flag == 0) return;
			ans = Math.min(Math.abs(a-b), ans);
			a = 1; 
			b = 0;
			return;
		}
		
		selected[cnt] = 1;
		subset(cnt+1);
		selected[cnt] = 0;
		subset(cnt+1);
	}
}
