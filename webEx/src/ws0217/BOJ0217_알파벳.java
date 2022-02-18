package ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ0217_알파벳 {
	static int R, C;
	static char[][] mat;
	static int[] dr = {0,1,0,-1};//우하죄상
	static int[] dc = {1,0,-1,0};//우하죄상
	static Map<Character, Integer> map = new HashMap<Character,Integer>();
	static int cnt = 1;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[R][C];
		for(int i=0; i<R; i++) {
			mat[i] = br.readLine().toCharArray();
		}//....입력완료
		
		//제일 처음의 알파벳 저장
		map.put(mat[0][0],1);
		
		//이동
		move(0,0);		
		System.out.println(ans);
	}
	
	static void move(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//해시맵이용하여 알파벳 중복체크
			if( nr>=0 && nr<R && nc>=0 && nc<C && map.getOrDefault(mat[nr][nc], 0) == 0) {
				map.put(mat[nr][nc],1);//move하기 전에 알파벳 추가
				cnt++; //카운트 추가
				move(nr,nc);//move!
				cnt--; //이동 끝났으니 카운트 줄이기
				map.put(mat[nr][nc],0); //알파벳도 다시 감소
			}else {
				if(i == 3) { //4방향 모두 돌아봐도 갈곳이 없으면 끝.
					ans = Math.max(ans,cnt);//끝가지 왔으니 최댓값 비교해봄.
					return;
				}
			}
			
		}
	}
}



















