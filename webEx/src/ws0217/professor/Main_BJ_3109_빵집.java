package ws0217;

//https://www.acmicpc.net/problem/3109
/*
[입력]
5 5
.xx..
..x..
.....
...x.
...x.
[출력]
2

[입력]
6 10
..x.......
.....x....
.x....x...
...x...xx.
..........
....x.....
[출력]
5
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3109_빵집 {
	static char[][] map;
	static int R, C;
	static int ans;
	static int[] di = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		map = new char[R][];
		
		for(int i=0; i<R; i++){
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			if(dfs(i,0)) 
				ans++;
		}
		System.out.println(ans);
	}
	
	static boolean dfs(int i, int j) {
		for(int d=0; d<3; d++) {
			int ni = i+di[d];
			int nj = j+1;
			if(ni>=0 && ni<R && map[ni][nj]=='.') { // 위,그대로,아래 칸중 하나가 파이프 놓을 수 있는 칸인지
				if(nj == C-1) {
					return true;     // 지도의 오른쪽 끝
				} 
				map[ni][nj] = 'X';   //한번 지나갔던길은 다시 못 지나가게 X 표시
//				System.out.println("["+ni+","+nj+"]");
				if(dfs(ni,nj)) {
					return true;
				}
			}
		}
		return false;
	}
} // 36912kb	292ms