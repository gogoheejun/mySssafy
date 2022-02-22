package 보충수업;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ12927_배수스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] lights = sc.next().toCharArray();

		int cnt=0;
//		System.out.println(Arrays.toString(lights));
		for(int i=1; i<lights.length+1; i++) {
			//켜져있으면 끄기
			if(lights[i-1]=='Y') {
				cnt++;
				for(int j=i-1; j<lights.length; j+=i) {
					lights[j] = (lights[j]=='Y')?'N':'Y';
				}
			}
//			System.out.println(Arrays.toString(lights));
		}
		System.out.println(cnt);
	}
}
