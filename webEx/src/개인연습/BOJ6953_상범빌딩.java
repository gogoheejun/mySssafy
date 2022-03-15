package 개인연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6953_상범빌딩 {
	
	static class Node{
		int f;
        int r;
        int c;
        int count;
        
        public Node(int f, int r, int c, int count) {
            this.f = f;
            this.r = r;
            this.c = c;
            this.count = count;
        }
	}

	static int L, R, C;
	static char[][][] mat;
	static Node s, e;
	static boolean[][][] visited;
	static int[] df = {0, 0, 0, 0, 1, -1}; //순서대로 오 왼 위 아래 위층 아래층
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;
			
			mat = new char[L][R][C];
			for(int f=0; f<L; f++) {
				for(int r=0; r<R; r++) {
					String line = br.readLine();
					mat[f][r] = line.toCharArray();
					for(int c=0; c<C; c++) {
						if(mat[f][r][c] =='S') {
							s = new Node(f,r,c,0);
						}else if(mat[f][r][c] =='E') {
							e = new Node(f,r,c,0);
						}
					}
				}		
				br.readLine();
			}
			visited = new boolean[L][R][C];
			System.out.println(Arrays.deepToString(mat));
			
			int result = bfs();
	        if(result == -1) System.out.println("Trapped!");
	        else System.out.println("Escaped in " + result + " minute(s).");
		}
		
		
	}
	
	static int bfs() {
		Queue<Node> qu = new LinkedList<>();
		qu.offer(new Node(s.f, s.r, s.c, 0));
		visited[s.f][s.r][s.c] = true;
		while(!qu.isEmpty()) {
			Node current = qu.poll();
			if(current.f == e.f && current.r == e.r && current.c == e.c) return current.count;
			
			 for(int i = 0; i < 6; i++) {
	                int nf = current.f + df[i];
	                int nr = current.r + dr[i];
	                int nc = current.c + dc[i];
	                
	                if(nf >= 0 && nf < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
	                    if(visited[nf][nr][nc] == false && mat[nf][nr][nc] != '#') {
	                        visited[nf][nr][nc] = true;
	                        qu.offer(new Node(nf, nr, nc, current.count + 1));
	                    }
	                }
	            }
		}
		
		return -1;
	}
	
}

















