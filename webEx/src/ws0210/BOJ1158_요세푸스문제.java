package ws0210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158_요세푸스문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<N+1; i++) {
			q.offer(i);
		}//입력끝

		StringBuilder sb = new StringBuilder("<");
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++) {//만약 3이면 두번만 돌림
				int out = q.poll();
				q.offer(out);
			}

			sb.append(q.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
