package 개인연습;

public class SK_02 {

	public static void main(String[] args) {
		solution(6, false);
	}
	
	static int[][] mat;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static int[][] solution(int n, boolean clockwise) {
		mat = new int[n][n];
        
        if(clockwise) {
        	move(0,0,n-1,1,0,true);
        	move(0,n-1,n-1,1,1,true);
        	move(n-1,n-1,n-1,1,2,true);
        	move(n-1,0,n-1,1,3,true);
        }else {
        	moveReverse(0,0,n-1,1,0,true);
        	moveReverse(n-1,0,n-1,1,1,true);
        	moveReverse(n-1,n-1,n-1,1,2,true);
        	moveReverse(0,n-1,n-1,1,3,true);
        }
//        for(int i=0; i<mat.length; i++) {
//        	for(int j=0; j<mat.length; j++) {
//        		System.out.print(mat[i][j]+"\t");
//        	}
//        	System.out.println();
//        }
        return mat;
    }
	static void moveReverse(int r, int c, int rep, int start, int dir, boolean firstFlag) {
		if(rep < 2) {
//			System.out.println("마지막: "+r+", "+c+",  start:"+start+"dir:"+dir);
			if(dir ==2) {
				mat[r-1][c] = start;
			}
			if(dir ==3) {
				mat[r][c-1] = start;
			}
			if(dir ==0) {
				mat[r+1][c] = start;
			}
			if(dir ==1) {
				mat[r][c+1] = start;
			}
			return;
		}
		
		//재귀
		switch (dir) {
		case 0:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r++][c]=start++;
					if(i==rep-1) {
						r-=1;
					}
				}else {
					mat[++r][c] = start++;
				}
//				mat[++r][c] = start++;
			}
			moveReverse(r,c,rep-2,start,1,false);
			break;
		case 1:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r][c++] = start++;
					if(i==rep-1) {
						c-=1;
					}
				}else {
					mat[r][++c] = start++;
				}
			}
			moveReverse(r,c,rep-2,start,2,false);
			break;
		case 2:
			for(int i=0; i<rep; i++) {
				if(firstFlag) {
					mat[r--][c] = start++;
					if(i==rep-1) {
						r+=1;
					}
				}else {
					mat[--r][c] = start++;
				}
			}
			moveReverse(r,c,rep-2,start,3,false);
			break;
		case 3:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r][c--] = start++;
					if(i==rep-1) {
						c+=1;
					}
				}else {
					mat[r][--c] = start++;
				}
			}
			moveReverse(r,c,rep-2,start,0,false);
			break;
		default:
			break;
		}
	}
	
	static void move(int r, int c, int rep, int start, int dir, boolean firstFlag) {
		if(rep < 2) {
//			System.out.println("마지막: "+r+", "+c+",  start:"+start+"dir:"+dir);
			if(dir ==3) {
				mat[r-1][c] = start;
			}
			if(dir ==0) {
				mat[r][c+1] = start;
			}
			if(dir ==1) {
				mat[r+1][c] = start;
			}
			if(dir ==2) {
				mat[r][c-1] = start;
			}
			return;
		}
		
		//재귀
		switch (dir) {
		case 0:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r][c++]=start++;
					if(i==rep-1) {
						c-=1;
					}
				}else {
					mat[r][++c] = start++;
				}
			}
			move(r,c,rep-2,start,1,false);
			break;
		case 1:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r++][c] = start++;
					if(i==rep-1) {
						r-=1;
					}
				}else {
					mat[++r][c] = start++;
				}
			}
			move(r,c,rep-2,start,2,false);
			break;
		case 2:
			for(int i=0; i<rep; i++) {
				if(firstFlag) {
					mat[r][c--] = start++;
					if(i==rep-1) {
						c+=1;
					}
				}else {
					mat[r][--c] = start++;
				}
			}
			move(r,c,rep-2,start,3,false);
			break;
		case 3:
			for(int i=0; i<rep; i++) {
				
				if(firstFlag) {
					mat[r--][c] = start++;
					if(i==rep-1) {
						r+=1;
					}
				}else {
					mat[--r][c] = start++;
				}
			}
			move(r,c,rep-2,start,0,false);
			break;
		default:
			break;
		}
	}
}
