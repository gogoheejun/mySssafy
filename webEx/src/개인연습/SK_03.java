package 개인연습;

public class SK_03 {
	public static void main(String[] args) {
		int[][] edges = {{2,3},{0,1},{1,2}};
		solution(4, edges);
		System.out.println("ans: "+ans);
	}
	
	static int[][] mat;
	public static long solution(int n, int[][] edges) {
 
        mat = new int[n][n];
        for(int i=0; i<edges.length; i++) {
        	int x = edges[i][0];
        	int y = edges[i][1];
        	mat[x][y] = mat[y][x] = 1;
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(mat[i][j]==1) {
        			System.out.println("시작");
        			dfs(n, i,j,1);
        		}
        	}
        }
        
        
        return ans;
    }
	static long ans;
	static void dfs(int n, int from, int to, int cnt) {
		System.out.println("from, to: "+from+", "+to);
		if(cnt>=2) {
			ans= ans+1+cnt-2;
		}
		for(int c=0; c<n; c++) {
			if(mat[to][c]==1 && c!=from) {
				dfs(n, to, c,cnt+1);
			}
		}
	}
}
