import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {

	static int D,W,K,film[][],min;
	static final int A=0, B=1;
	static int[] drugA, drugB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; ++tc) {
			st = new StringTokenizer(in.readLine().trim());
			D = Integer.parseInt(st.nextToken());//막 두께(세로)
			W = Integer.parseInt(st.nextToken());//막 너비(가로)
			K = Integer.parseInt(st.nextToken());//합격기준 연속 셀의 개수
			
			film = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];
			min = Integer.MAX_VALUE;
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력처리
			
			Arrays.fill(drugA, A);
			Arrays.fill(drugB, B);
			
			process(0, 0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	
	private static boolean check() {//보호필름 성능검사
		//열 고정하고 행 탐색할 때 연속된 셀의 같은 특성이 K개 이상인지 검사
		for(int c=0; c<drugA.length; c++) {//열 고정
			int count = 1;
			int before = film[0][c];
			for(int r=1; r<D; r++) {
				int current = film[r][c];
				if(before == current) {
					if(++count == K) break;
				}else {
					before = current;
				}
			}//하나의 열을 고정해서 수직검사
			if(count<K) return false;
		}
		return true;
	}
	private static boolean process(int row, int useCnt) {//각 층마다 부분집합으로 약품 비투여, A투여, B투여
		
		if(row==D) {
			if(check()) {
				min = Math.min(min,useCnt);
				return min == 0;//약품을 하나도 사용하지 않았으면 true
			}
			
			return false;
		}
		
		if(useCnt>=min) return false;//기존임시최적해의 최소약품수보다 현재까지 사용한 약품수가 같거나 크면 의미없으므로 리턴
		
		
		int[] backup = film[row];
		//약품 비투여..비투여 먼저 넣어야 시간 줄일 수 있음. 젤 조금쓰는거 구하는거라.
		if(process(row+1, useCnt)) return true;
		//약품 A투여
		film[row] = drugA;
//		if(process(row+1, useCnt)) return true;
		process(row+1, useCnt);
		//약품 B투여
		film[row] = drugB;
//		if(process(row+1, useCnt)) return true;
		process(row+1, useCnt);
		
		film[row] = backup;//기존 막의 상태로 다시 돌려놓음.
		return false;
	}

}






