package ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9929_구미_5반_양희준 {
	static int N, M;
	static int[] snacks;
	static int answer=-1;
	static int[] weights;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ct=1; ct<=T; ct++) {
			//입력값 받아서 값 설정
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());//총 과자 개수
			M = Integer.parseInt(st.nextToken());//최대 무게
			snacks = new int[N]; //과자들 배열
			weights = new int[2];//양손에 들 과자조합(두개)
			String weights = br.readLine();
			st = new StringTokenizer(weights);
			
			for(int i=0; i<N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			//조합
			combi(0,0);
			
			//답출력
			System.out.println("#"+ct+" "+answer);
			answer = -1; //클래스변수 초기화
		}
	}
	
	public static void combi(int cnt, int start) {
		
		if(cnt == 2) { //왼손 오른손은 총 두개이므로 두개까지만.
			int sum = 0;
			for(int weight : weights) {
				sum +=weight;
			}
			if(sum>answer && sum <=M) answer = sum;
			
//			System.out.println(Arrays.toString(weights)+", "+sum+"//"+answer);
			return;
		}
		for(int i=start; i<N; i++) {
			weights[cnt] = snacks[i];
			combi(cnt+1,i+1);
		}
	}
}
