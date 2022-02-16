package ws0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1828_냉장고 {

	//정렬을 위해 Comparable 상속
	private static class Temperatures implements Comparable<Temperatures> {
		int min;
		int max;

		public Temperatures(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Temperatures o) {
			int diff = this.max - o.max;
			return diff != 0 ? diff : this.min - o.min;// 최댓값으로 오름차순정렬, 같으면 최솟값으로 오름차순정렬
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Temperatures[] temps = new Temperatures[N];


		int ans = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			temps[i] = new Temperatures(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(temps);
		int maxNum = temps[0].max;

		//기존의 최댓값보다 다음온도의 최솟값이 더 크면 기존냉장고로 커버를 못하니까 하나 더 증가
		for(int i=0; i<N-1; i++) {
			if(maxNum < temps[i+1].min) {
				ans++;
				maxNum = temps[i+1].max;
			}
		}

		System.out.println(ans);
	}

}
