import java.util.Scanner;

public class SquareNumberDivideTEst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(exp(x,n)); //오버플로우 일어나는거 상관없이 일단 callCnt찍히는것만 보셈
		System.out.println(callCnt);
	}
	static int callCnt = 0;
	public static long exp(long x, long n) {
		
		callCnt++;
		if(n==1) return x;
		long y =exp(x, n/2);
		
		return (n%2==0)? y*y :y*y*x;//홀수면 자기자신 한번더 곱해야 함
	}
}
