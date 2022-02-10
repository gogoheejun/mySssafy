package ws0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No8_BOJ2527_직사각형 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] answer = new char[4];
		for(int i=0; i<4; i++) {
//			Scanner sc = new Scanner(System.in);
//			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1s = Integer.parseInt(st.nextToken());
			int y1s = Integer.parseInt(st.nextToken());
			int x1e = Integer.parseInt(st.nextToken());
			int y1e = Integer.parseInt(st.nextToken());
			int x2s = Integer.parseInt(st.nextToken());
			int y2s = Integer.parseInt(st.nextToken());
			int x2e = Integer.parseInt(st.nextToken());
			int y2e = Integer.parseInt(st.nextToken());
			
			//직사각형
			if((x1s<x2s && x2s<x1e) || (x1s<x2e && x2e<x1e) 
					&&
				(y1s<y2s && y2s<y1e) || (y1s<y2e && y2e<y1e)
				) {
//				System.out.println('a');
				answer[i] = 'a';
				continue;
			}
			
			//선분
			if(((x1e == x2s) || (x1s ==x2e))&& (y1s<y2s && y2s<y1e) || (y1s<y2e && y2e<y1e)) {
				answer[i] = 'b';
				continue;
			}
			if(((y1e == y2s) || (y1s ==y2e))&& (x1s<x2s && x2s<x1e) || (x1s<x2e && x2e<x1e))  {
				answer[i] = 'b';
				continue;
			}
			
			//점
			if((x1e == x1s && y1s == y2e) 
				|| (x1e == x2s && y1e == y2s)
				|| (x1s == x2e && y1s == y2e)
				|| (x1s == x2e && y1e == y2s)) {
				answer[i] = 'c';
				continue;
			}
			
			//없음
			if(x1e<x2s ||
				x2e<x1s ||
				y1e<y2s ||
				y2e<y1s) {
				answer[i] = 'd';
				continue;
			}
		}
		for(int i=0; i<4; i++) {
			System.out.println(answer[i]);
		}
		
		
	}

}
