import java.util.Scanner;

public class test {

	static char[] choices;
	static char[] abc = {'a','b','c'};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(1);
	}
	static void dfs(int cnt) {
		if(cnt > N) {
			return;
		}
		dfs2(0,cnt);
		System.out.println();
		dfs(cnt+1);
	}
	
	static void dfs2(int now, int max) {
		if(now==max) {
			return;
		}
		System.out.print("*");
		dfs2(now+1,max);
	}
}

