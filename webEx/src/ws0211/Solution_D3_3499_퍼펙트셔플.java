package ws0209;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플 {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ws0209/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + String.valueOf(tc) + " ");
			int N = sc.nextInt();
			String[] deck = new String[N];
			for (int i = 0; i < N; i++) {
				deck[i] = sc.next();
			}
			int half = N / 2;
			int remain = N % 2;
			for (int i = 0; i < half; i++) {
				bw.append(deck[i] + " " + deck[remain + half + i] + " ");
			}
			if (remain > 0)
				bw.append(deck[half]);
			bw.append("\n");
		}
		bw.flush();
		sc.close();
	}
}
