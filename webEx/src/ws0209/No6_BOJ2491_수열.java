package ws0209;

import java.util.Scanner;

public class No6_BOJ2491_수열 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int increaseCnt = 0;
		int sameCnt = 0;
		int decreaseCnt = 0;
		
		int status = 0;//1:증가추세, 0:똑같, -1:감소
		
		int answer = 0;
		int lastNum = -1;
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int nowNum = sc.nextInt();
			if(nowNum > lastNum) {
				if(status == 1 || status == 0) {
					increaseCnt++;
					status = 1;
					System.out.println("증가증가"+increaseCnt+" "+sameCnt);
				}else if( status == -1) {//감소하다 증가
					
					increaseCnt++;
					//decreaseCnt 초기화
					if(decreaseCnt+sameCnt>answer) {
						answer = decreaseCnt+sameCnt;
					}
					decreaseCnt = 0;
					sameCnt = 0;
					status = 1;
					System.out.println("감소증가"+increaseCnt+" "+sameCnt);
				}
			}
			if(nowNum < lastNum) {
				if(status == -1 || status == 0) {
					System.out.println("감소감소"+decreaseCnt+" "+sameCnt);
					decreaseCnt++;
					status = -1;
				}else if( status == 1) {//증가하다 감소
					decreaseCnt++;
					//increaseCnt 초기화
					if(increaseCnt+sameCnt>answer) {
						answer = increaseCnt+sameCnt;
					}
					increaseCnt = 0;
					sameCnt = 0;
					status = -1;
					System.out.println("증가감소"+decreaseCnt+" "+sameCnt);

				}
			}
			if(nowNum == lastNum) {
				sameCnt++;
				status = 0;
				System.out.println("똑같"+decreaseCnt+" "+sameCnt);
			}
		}
		System.out.println(answer);
	}
}
