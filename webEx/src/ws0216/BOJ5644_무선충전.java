package ws0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5644_무선충전 {

	static int M, A;
	static int[] aStep, bStep;
	static int[][] mat = new int[10][10];
	static int sumA, sumB;
	static int[] dr = {0,-1,0,1,0};//그대로,상,우,하,좌
	static int[] dc = {0,0,1,0,-1};//그대로,상,우,하,좌
	static Charger[] chargers;
	static class Charger{
		int c;
		int r;
		int dis;
		int power;
		public Charger(int c, int r, int dis, int power) {
			this.c = c;
			this.r = r;
			this.dis = dis;
			this.power = power;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());// 총 이동시간
			A = Integer.parseInt(st.nextToken());// BC의 개수
			chargers = new Charger[A];
			int SUM =0;

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			aStep = new int[M+1];
			bStep = new int[M+1];
			int m=0;
			while(st1.hasMoreTokens()) {
				aStep[m] = Integer.parseInt(st1.nextToken());
				bStep[m] = Integer.parseInt(st2.nextToken());
				m++;
			}//..스텝입력
			
			for(int i=0; i<A; i++) {//무선충전기 정보 입력
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				int dis = Integer.parseInt(st.nextToken());
				int power =  Integer.parseInt(st.nextToken());
				Charger charger = new Charger(c,r,dis,power);
				chargers[i] = charger;
			}
			
			//로직처리 시작----
			int rA = 0, cA = 0;//A시작점
			int rB = 9, cB = 9;//B시작점
			for(int i=0; i<=M; i++) {//매 스텝별로
//				System.out.println("rA,cA  "+rA+","+cA);
				
				
				int[] powersA = new int[A];//A범위 안에 있는 충전기 파워정보들
				int[] powersB = new int[A];//B 
				for(int j=0; j<A; j++) {//각 무선충전기 별 검사
					Charger charger = chargers[j];
					//A검사
					int disA = Math.abs(rA-charger.r) + Math.abs(cA - charger.c);
					if(disA <= charger.dis) {//충전가능해질때
						powersA[j] = charger.power;
					}
					//B검사
					int disB = Math.abs(rB-charger.r) + Math.abs(cB- charger.c);
					if(disB <= charger.dis) {//충전가능해질때
						powersB[j] = charger.power;
					}
				}
				//최댓값구하기
				int maxAB=0;
				for(int j=0; j<A; j++) {
					for(int k=0; k<A; k++) {
						if(j == k) {
							int sum = powersA[k];//둘이 하나 공유하는 경우임
							maxAB = Math.max(maxAB, sum);
						}else {
							maxAB = Math.max(maxAB, powersA[j]+powersB[k]);
						}
					}
				}
				System.out.println("max: "+maxAB);
				System.out.print(Arrays.toString(powersA)+"//");
				System.out.print(Arrays.toString(powersB)+"//");
				System.out.println();
				SUM += maxAB;
				
				//다음스텝으로 이동
				rA = rA+dr[aStep[i]];
				cA = cA+dc[aStep[i]];
				
				rB = rB+dr[bStep[i]];
				cB = cB+dc[bStep[i]];
				
			}
			int ans = SUM;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}

}
