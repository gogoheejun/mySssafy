package ws0207;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
1
2 300
50 250
15 60

1
5 1000
100 200
300 500
250 300
500 1000
400 400

1
3 500
50 200
30 300
20 250
 */
public class Solution_D3_5215_햄버거다이어트 {
	static int answer;  //조합된 맛의 점수
	static int maxCal;  //제한칼로리
	static int N;       //재료수
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src/ws0207/input1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			answer=0;
			
		    N = sc.nextInt();             // 재료수
			maxCal = sc.nextInt();
			int [][] R = new int[N][2];   // [(맛의점수, 칼로리), ...]
			for (int i = 0; i < R.length; i++) {
				R[i][0] = sc.nextInt();
				R[i][1] = sc.nextInt(); 
			}
			int idx = 0;
			int curPoint = 0;
			int curCal =0;
			find(R, idx, curPoint, curCal);   // 배열, 0, 0, 0
			System.out.println("#" + tc + " " + answer);
		}
	}

	static void find(int[][] R, int idx, int curPoint, int curCal) {
		if ( curCal > maxCal ) {
			return; 
		}
		if ( curPoint > answer ) {
			answer = curPoint;
		}
		if ( idx == N) {
			return;
		}
		find(R, idx+1, curPoint+R[idx][0], curCal + R[idx][1]);// 현재 재료 사용
		find(R, idx+1, curPoint, curCal);                      // 현재 재료 안쓰기
	}
}
/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
*/