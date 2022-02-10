package ws0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No9_BOJ10158_자리배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();//관객대기번호
		
		int[][] mat = new int[R][C];
		int nowR = R-1;
		int nowC = 0;
		mat[nowR][nowC] = 1;
		Queue<String> dir = new LinkedList<String>();
		dir.add("up");
		dir.add("right");
		dir.add("down");
		dir.add("left");
		int cnt = 1;
		while(cnt <= C*R) {
			if(cnt == K) {
				System.out.println(R-nowR);
				return;
			}
			String nowDir = dir.peek();
			
			switch (nowDir) {
			case "up":
				if(nowR-1>=0 && mat[nowR-1][nowC] != 1) {
					nowR -=1;
					mat[nowR][nowC] = 1;
					cnt++;
				}else {
					String newDir = dir.poll();
					dir.offer(newDir);
				}
				break;
				
			case "right":
				break;
			case "down":
				break;
			case "left":
				break;
			default:
				break;
			}
		}
	}

}
