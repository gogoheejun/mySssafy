package 개인연습;

import java.util.Scanner;

public class BOJ1904_01타일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n+1];
		d[0] = 0; 
		if(n>=1) {
			d[1] = 1; 
		}
		if(n>=2) {
			d[2] = 2;
		}
		

		for(int i=3;i<=n;i++){
            d[i] = d[i-2] + d[i-1];
            d[i]%=15746;
        }

		
		System.out.println(d[n]);

	}

}
