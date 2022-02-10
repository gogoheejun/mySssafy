package ws0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//제출완료
public class No9_BOJ10157_자리배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();//관객대기번호
		
		int[][] mat = new int[R][C];
		int nowR = R-1;
		int nowC = 0;
		mat[nowR][nowC] = 1;//처음시작점 체크
		Queue<String> dir = new LinkedList<String>();
		dir.add("up");
		dir.add("right");
		dir.add("down");
		dir.add("left");
		int cnt = 1;
		
		int cantSearch = 0;
		while(cnt <= C*R) {
			if(cantSearch == 5) {
				System.out.println(0);
				return;
			}
			if(cnt == K) {
				System.out.println((nowC+1)+" "+(R-nowR));
				return;
			}
			String nowDir = dir.peek();
			
			switch (nowDir) {
			case "up":
				if(nowR-1>=0 && mat[nowR-1][nowC] != 1) {
					nowR -=1;
					mat[nowR][nowC] = 1;
					cnt++;
					cantSearch=0;
				}else {
					String newDir = dir.poll();
					dir.offer(newDir);
					cantSearch++;
				}
				break;
				
			case "right":
				if(nowC+1<=C-1 && mat[nowR][nowC+1] != 1) {
					nowC +=1;
					mat[nowR][nowC] = 1;
					cnt++;
					cantSearch=0;
				}else {
					String newDir = dir.poll();
					dir.offer(newDir);
					cantSearch++;
				}
				break;
			case "down":
				if(nowR+1<=R-1 && mat[nowR+1][nowC] != 1) {
					nowR +=1;
					mat[nowR][nowC] = 1;
					cnt++;
					cantSearch=0;
				}else {
					String newDir = dir.poll();
					dir.offer(newDir);
					cantSearch++;
				}
				break;
			case "left":
				if(nowC-1>=0 && mat[nowR][nowC-1] != 1) {
					nowC -=1;
					mat[nowR][nowC] = 1;
					cnt++;
					cantSearch=0;
				}else {
					String newDir = dir.poll();
					dir.offer(newDir);
					cantSearch++;
				}
				break;
			default:
				break;
			}
		}
	}

}
