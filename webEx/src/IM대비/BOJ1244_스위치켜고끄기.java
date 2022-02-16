package IM대비;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1244_스위치켜고끄기 {

	static int[] lights;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//스위치 개수
		lights = new int[N];
		for(int i=0; i<N; i++) {
			lights[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int sex = sc.nextInt();
			int idx = sc.nextInt();
			
			if(sex == 1) {//남자
				int num = idx;
				while(idx-1<N) {
					lights[idx-1] = (lights[idx-1]==1)?0:1;
					idx +=num;
				}
//				System.out.println(Arrays.toString(lights));
			}else {
				int move = 0;
				while(idx-1-move >=0 && idx-1+move<N) {
					if(move == 0) {
						lights[idx-1-move] = (lights[idx-1-move]==1)?0:1;
						move++;
						continue;
					}
					if(lights[idx-1-move] == lights[idx-1+move]) {
						lights[idx-1-move] = (lights[idx-1-move]==1)?0:1;
						lights[idx-1+move] = (lights[idx-1+move]==1)?0:1;
					}else {
						break;
					}
					move ++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(lights[i]).append(" ");
			if((i+1)%20 == 0) {
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

}
