package ws0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 연습장1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y1s = Integer.parseInt(st.nextToken());
		int x1s = Integer.parseInt(st.nextToken());
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
			System.out.println('a');
		}
	}
}
