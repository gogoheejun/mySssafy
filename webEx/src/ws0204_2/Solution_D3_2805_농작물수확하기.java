package ws0204_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[입력]
1
5
14054
44250
02032
51204
52212

[출력]
#1 23
*/
public class Solution_D3_2805_농작물수확하기{
	private static int map[][], N,center;
	public static void main(String[] args) throws FileNotFoundException  {
//		System.setIn(new FileInputStream("src/ws0204/input2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; ++t) {
			N = sc.nextInt();
			map = new int[N][N];
			center = N/2;
			char[] temp = null;
			for(int i=0; i<N; ++i) {
				temp = sc.next().toCharArray();
				for(int j=0; j<N; ++j) {
					map[i][j] = temp[j]-'0';
				}
			}
			System.out.println("#"+t+" "+getProfit());
		}
		sc.close();
	}//main
	
	private static int getProfit() {
		int profit = 0,begin,end,gap=0;
		for(int i=0; i<N; ++i) {
			begin = center - gap;
			end = center + gap;
			for(int j=begin; j<=end; ++j) {
				profit += map[i][j];
			}
			if(i<center) {
				gap++;
			}else {
				gap--;
			}
		}
		return profit;
	}
}
/*
[디버그]
F11: Debug모드로 실행하기
F5:  함수 안으로 들어가서 한단계씩 실행(step into)
F6:  함수를 하나의 문장으로 실행(step over)
F7:  타고들어온 함수가 다 실행되지 않았어도 나머지 다 실행하고 나옴(되돌아 가기)
F8:  나머지 코드를 다 실행, 다음 break point가 있다면 그쪽으로 이동   
*/























