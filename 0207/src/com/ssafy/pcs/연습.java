package com.ssafy.pcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연습 {
	
	public static void main(String[] args) {
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		char[] nodes = {0,'a','b','c','d','e','f','g','h','i','j','k','l'};// 트리에 문자저장할거임
		int lastIdx = 11;
		q.offer(1);
		int level = 0;
		while(!q.isEmpty()) {
			System.out.print("level:"+level+" ");
			int size = q.size();
			for(int i=0; i<size; i++) {
				int current = q.poll();
				System.out.print(nodes[current]+" ");
				if(current*2 <= lastIdx) q.offer(current*2);
				if(current*2 +1 <= lastIdx) q.offer(current*2+1);
			}
			level++;
			System.out.println();
		}
		
	}
}
