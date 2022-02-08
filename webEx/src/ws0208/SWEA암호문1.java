package ws0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
[입력]
10
4 6 8 2 3 5 9 1 4 5
3
I 3 2 10 11 I 5 4 22 33 44 55 I 6 3 99 88 77

[출력]
#1 4 6 8 10 11 22 99 88 77 33 
*/
public class SWEA암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;//10
		
		for(int tc=1; tc<=T; tc++) {
			LinkedList<Integer> answer = new LinkedList<Integer>();
			//테스트케이스가 네줄이므로 네개씩 
			int redNumber = Integer.parseInt(br.readLine());
			
			String blueNumber = br.readLine();
			StringTokenizer st = new StringTokenizer(blueNumber);
			
			for(int j=0; j<redNumber; j++) {
				answer.add(Integer.parseInt(st.nextToken()));
			}
			
			int greenNumber = Integer.parseInt(br.readLine());
			String purpleNumber =  br.readLine();
			st = new StringTokenizer(purpleNumber);
			for(int j=0; j<greenNumber; j++) { //명령어 개수만큼 실행
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				
				for(int k=0; k<cnt; k++) {//answer에 숫자 삽입
					answer.add(idx,Integer.parseInt(st.nextToken()));
					idx +=1;
				}
				System.out.println(answer);
			}
			StringBuilder sb = new StringBuilder("#"+tc);
			for(int i=0; i<10; i++) {
				sb.append(" "+answer.get(i));
			}
			System.out.println(sb);
		}
	}

}
