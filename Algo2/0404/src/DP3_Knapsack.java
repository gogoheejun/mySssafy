import java.util.Scanner;

public class DP3_Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		int[][] results = new int[N+1][W+1];
		
		//i=0은 0으로 둠.
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int itemWeight = 0, itemBenefit = 0;
		//모든 아이템에 대해 반복
		for(int item = 1; item<=N; item++) {
			itemWeight = weights[item];
			itemBenefit = profits[item];
			
			for(int weight = 1; weight<=W; weight++) {
				if(itemWeight<=weight) {//지금꺼 담을 수 있는 상황
					//안담을때: 직전물건까지 weight만족하는 최적해  vs 담을때: 현재가치 + (안담을때의 현재weight-현재itemWeight의 가치)
					results[item][weight] = Math.max(results[item-1][weight],itemBenefit+results[item-1][weight-itemWeight]);
				}else {//못 담을 땐 걍 바로직전꺼 그대로.
					results[item][weight] = results[item-1][weight];
				}
			}
		}
		System.out.println(results[N][W]);
	}
}

















