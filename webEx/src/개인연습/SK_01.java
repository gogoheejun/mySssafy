package 개인연습;

public class SK_01 {
	
	public static void main(String[] args) {
		int[] costs = {1, 4, 99, 35, 50, 1000};
		solution(4578,costs);
	}
	public static int solution(int money, int[] costs) {
        int answer = 0;
        
        makeMoney(money, costs,0,0);
        
        System.out.println(costSum);
        return costSum;
    }
	
	static int moneySum = 0; 
	static int costSum=0;
	static int min = Integer.MAX_VALUE;
	static int[] coins = {1,5,10,50,100,500};
	static void makeMoney(int money, int[] costs, int tempMoney, int tempCost) {
		if(moneySum == money) {
			//min이랑 sum비교
			min = Math.min(costSum, min);
			return;
		}
		if(moneySum>money) {
			//종료
			moneySum-=tempMoney;
			return;
		}
		if(costSum > min) {
			//종료
			costSum-=tempCost;
			return;
		}
		
		for(int i=5; i>=0; i--) {
			costSum+=costs[i];
			moneySum+=coins[i];
			makeMoney(money, costs, coins[i], costs[i]);
//			costSum-=costs[i];
//			moneySum-=coins[i];
		}
	}
}
