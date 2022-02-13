package IM대비;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No12_BOJ2635_수이어가기 {
	static int cnt;
	static int ans = 0;
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> list2 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i=1; i<=a; i++) {
			list.clear();
			list.add(a);
			cnt=2;
			
			int b = i;
			
			recur(a,b);
			if(cnt > ans) {
				list2.clear();
				ans = cnt;
				for(int j=0; j<cnt; j++) {
					list2.add(list.get(j));
				}
			}
		}
		System.out.println(ans);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ans; i++) {
			sb.append(list2.get(i)+" ");
		}
//		if(sb.length()>1) {
//			sb.setLength(sb.length()-1);
//		}
		
		System.out.println(sb);
		
	}
	
	public static void recur(int num1, int num2) {
		list.add(num2);
		int num = num1 - num2;
		if(num < 0) {
			return;
		}
		cnt++;
		recur(num2, num);
	}
	
	
}
