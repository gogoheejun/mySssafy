

import java.util.Scanner;
/*
 * 자연수로 이뤄진 집합으로 21만드는 경우 몇번인지.
 * (자연수가 포인트. 자연수니까 줄어들 일이 없어서 S를 넘어서면 더 이상 세지 않도록 가지치기해버리는 것임)
6 21
5 21 11 16 6 10
 */
public class SubSetSumTest2 {

	static int N,input[], S, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		ans = 0;
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0,0);
		System.out.println(ans);
	}
	
	public static void generateSubset(int cnt, int sum) { // cnt:부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
													//sum: 직전까지 구성된 부분집합의 합
		
		if(sum == S) {
			ans++;
			for (int i = 0; i < cnt; i++) {
				System.out.print((isSelected[i]?input[i]+" ":""));
			}
			System.out.println();
			return;
		}
		if(sum>S) { // 마지막 원소까지 부분집합에 다 고려된 상황			
			return;
		}
		if(cnt == N) {
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1, sum+input[cnt]);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1, sum);
	}

}










