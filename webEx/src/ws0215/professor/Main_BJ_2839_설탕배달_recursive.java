package ws0215.professor;
import java.util.Scanner;

public class Main_BJ_2839_설탕배달_recursive {
	static int goal;
	static int ans = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		goal = sc.nextInt();
		solve(0, 0);
		System.out.println(ans);
	}
	static void solve(int weight, int cnt) {
		if (weight > goal) return;
		if (weight == goal) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		solve(weight + 5, cnt + 1);
		solve(weight + 3, cnt + 1);
	}
}
// 12184kb/ 120ms