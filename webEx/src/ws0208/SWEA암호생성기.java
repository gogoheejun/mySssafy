package ws0208;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
1
10 6 12 8 9 4 1 3

#1 3 9 4 9 4 4 3 0
*/
public class SWEA암호생성기 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);

		int T = 2;

		for (int tc = 1; tc < T + 1; tc++) {
			int t= sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}


			boolean isDone = false;
			int num=0;
			while (!isDone) {
				for (int i = 1; i <=5; i++) {
					num = q.poll() -i;	//맨 앞에 숫자 추출해서 암호로 변경
					if(num<=0) {
						num = 0;
						isDone = true;
					}
					q.offer(num);
					if(isDone) {
						return;
					}
				}
			}
			String ans = q.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" "));

			System.out.println("#" + t + " " + ans);
			q.clear();

		}
	}

}
