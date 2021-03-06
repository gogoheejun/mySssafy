package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No05_BOJ2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int M = Integer.parseInt(line[0]);
		int N = Integer.parseInt(line[1]);
		int S = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		int totalLength = (N+M)*2;
		
		for(int tc=0; tc<S+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			
			if(direction == 1) {
				list.add(position);
			}else if(direction ==2) {
				list.add(M+N+(M-position));
			}else if(direction == 3) {
				list.add(2*M + N +(N-position));
			}else {
				list.add(M+position);
			}
		}
		int leng = list.get(list.size()-1);
		int answer = 0;
		for(int i=0; i<S; i++) {
			int tmp = Math.abs(list.get(i)-leng);
			answer += Math.min(tmp, totalLength-tmp);
		}
		System.out.println(answer);
	}
}
