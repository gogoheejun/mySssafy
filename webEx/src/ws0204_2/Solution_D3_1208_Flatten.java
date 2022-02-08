package ws0204_2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[SW문제해결 기본] 1일차 Flatten (1208-D3)
public class Solution_D3_1208_Flatten {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ws0204_2/input3.txt"));
		Scanner sc=new Scanner(System.in);
		int[] ans=new int[10];
		
		for(int tc=1; tc<=10; tc++) {
			int dump=sc.nextInt();
			int[] numbers=new int[100];  // 상자의 가로길이 100고정
			
			for(int i=0; i<100; i++) {
				numbers[i]=sc.nextInt();
			}
			Arrays.sort(numbers);
			
//			for(int i=0; i<100; i++) {
//				System.out.print(numbers[i]+" ");
//			}
//			System.out.println();
			
			for(int i=0; i<dump; i++) {
				numbers[0]++;
				numbers[99]--;
				Arrays.sort(numbers);
			}
			ans[tc-1]=numbers[99]-numbers[0];
		}
		
		//출력-----------------------------------
		for(int i=0; i<10; i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
}







