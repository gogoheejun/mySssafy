package 보충수업.일주차;

import java.util.Scanner;
import java.util.Stack;

public class SWEA5432_쇠막대기자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int res = 0;
			String s = sc.next();
//			char[] chs = s.toCharArray(); 이렇게 배열만들어도 되고 걍 s.charAt()써도 되고상관없음
			char[] stack = new char[100000];
			int top = -1;//top포인터
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '(') {
					top++;
					stack[top] = '(';
				}else {
					if(s.charAt(i-1)=='(') {//레이저
						res += top;
						stack[top] = ' ';
						top--;
					}else {//쇠막대기의 끝
						res++;
						stack[top] = ' ';
						top--;
					}
				}
			}
			
			System.out.println("#"+tc+ " "+res);
		}
		
	}

}
