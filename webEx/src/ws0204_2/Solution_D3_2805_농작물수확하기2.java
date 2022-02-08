package ws0204_2;

/*
[입력]
3
1
3
3
132
254
021
5
05023
33212
12511
23321
24132

[출력]
#1 3
#2 16
#3 25
*/
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int sum = 0;
            int N = sc.nextInt();

            for (int j = N / 2; j >= 0; j--) {
                String s = sc.next();
                for (int k = j; k < N - j; k++) {
                    sum += s.charAt(k) - '0';
                }
            }
            
            for (int j = 1; j <= N / 2; j++) {
                String s = sc.next();
                for (int k = j; k < N - j; k++) {
                    sum += s.charAt(k) - '0';
                }
            }
            
            System.out.println("#" + i + " " + sum);
        }
    }
}
//--------------------------------------------------------------------
/*
[입력]
5

[출력]
2
123
01234
123
2
*/
/*
public class Solution_D3_2805_농작물수확하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;

		for (int j = N / 2; j >= 0; j--) {
			for (int k = j; k < N - j; k++) {
				System.out.print(k);
			}
			System.out.println();
		}

		for (int j = 1; j <= N / 2; j++) {
			for (int k = j; k < N - j; k++) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
}
*/
