import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class devMatch02 {
	public static void main(String[] args) {
		String[] grid = {"aa?"};
		solution(grid);
		System.out.println(ans);
	}
	
	
	static class Point{
		int r;
		int c;
		char ch;
		public Point(int r, int c,char ch) {
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
	}

	static char[] choices;
	static char[] abc = {'a','b','c'};
	static int qCnt, n, m;
	static char[][] mat;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	static int ans=0;
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	public static int solution(String[] grid) {
		
		n = grid.length;
		m = grid[0].length();
		mat = new char[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			mat[i] = grid[i].toCharArray();
		}
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(mat[r][c]=='?') qCnt++;
			}
		}
			
		//qCnt만큼 경우의수
		choices = new char[qCnt]; //
		dfs(0,grid);

		return ans;
	}
	static void dfs(int cnt, String[] grid) {
		if(cnt==qCnt) {
			//mat ?에 넣기
			putChar(grid);
			//a,b,c집단 개수 구하기
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!visited[i][j]) {
						map.put(mat[i][j], (Integer)map.getOrDefault(mat[i][j], 0)+1);
						bfs(i,j);
					}		
				}
			}
			if(map.getOrDefault('a',0)<=1 && map.getOrDefault('b',0)<=1 && map.getOrDefault('c',0)<=1) {
				ans++;
			}
		
			visited = new boolean[n][m];//방문 초기화
			map = new HashMap<Character, Integer>();//map 초기화
			return;
		}
		for(int i=0; i<3; i++) {
			choices[cnt] = abc[i]; 
			dfs(cnt+1,grid);
		}
	}

	
	static void bfs(int r, int c) {
		Queue<Point> qu = new LinkedList<>();
		qu.offer(new Point(r,c,mat[r][c]));
		visited[r][c] = true;
		while(!qu.isEmpty()){
			Point point = qu.poll();
			
			for(int i=0;i<4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]) {
					if(mat[nr][nc] == point.ch) {
						qu.offer(new Point(nr,nc,point.ch));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	static void putChar(String[] grid) {
		mat = new char[n][m];
		for(int i=0; i<n; i++) {
			mat[i] = grid[i].toCharArray();
		}
		int i=0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(mat[r][c]=='?') {
					mat[r][c] = choices[i];

					i++;
				}
//				System.out.print(mat[r][c]);
			}
//			System.out.println();
		}
//		System.out.println("===========");
	}
}
