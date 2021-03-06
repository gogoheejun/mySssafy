package IM대비;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
//제출완료
public class No02_BOJ2605_줄세우기 {

	static int N;
	static int[] inputs;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		LinkedList<Integer> students = new LinkedList<>();
				
		for(int i=0; i<N; i++) {
			inputs[i] = sc.nextInt();
			students.add(i+1);
		}
		///
		
		for(int i=0; i<N; i++) {
			int popped = students.get(i);
			students.remove(i);
			
			int move = inputs[i];
			students.add(i-move,popped);
		}
	
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<students.size(); i++) {
			sb.append(students.get(i)+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
