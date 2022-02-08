package 보충수업;
//문제는 외부공개불가이므로 하드디스크에 있는 첨부파일 참고
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 기지국 {

	static int n;
	static char[][] map;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("기지국_input.txt"));//제출할땐 주석처리 ㄱ
		Scanner sc = new Scanner(System.in);//IM시험에서는 BufferedReader안써도됨
		int TC = sc.nextInt();
		
		for(int t = 1; t<=TC; t++) {
			int res = 0;
			n = sc.nextInt();
			map = new char[n][n];
			//입력
			String s;
			for(int i=0; i<n; i++) {
				s = sc.next();//문자열 읽을땐 nextline하지말고 걍 다 next해라
				for(int j=0; j<n; j++) {
					map[i][j] = s.charAt(j);
				}
			}//읽기완성
			
//			for(int i=0; i<n; i++) { //디버깅
//				for(int j=0; j<n; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//처리1: 기지국 처리(기지국 처리된 집(H=>X))
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 'X'|| map[i][j]=='H') {//기지국이냐 아니냐...교수님은 가지치기 더 선호하심(continue) if밖에다 쓰기
						continue;
					}
					//기지국(A-1칸,B-2칸,C-3칸)
					for(int k=1; k<= map[i][j]-'A'+1; k++) {//기지국 종류에 따라 반복회수 달라짐
						//동
						if(j+k < n && map[i][j+k] == 'H') {
							map[i][j+k] = 'X';
						}
						//서
						if(j-k > -1 && map[i][j-k] == 'H') {
							map[i][j-k] = 'X';
						}
						//남
						if(i+k<n && map[i+k][j] == 'H') {
							map[i+k][j] = 'X';
						}
						//북
						if(i-k > -1 && map[i-k][j] == 'H') {
							map[i-k][j] = 'X';
						}
					}
				}
			}
			
			
			//처리2: 빈집 세기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					//집(H)이면 res 누적
					if(map[i][j] == 'H') {
						res += 1;
					}
				}
			}
			
			
			//출력
			System.out.println("#"+t+" "+res);
		}
		
	}
}
