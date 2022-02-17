import java.util.Scanner;

public class QueenBackTrackingTest {
	
	static int N;
	static int col[];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];//0은 안씀
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) {//rowNo: 퀸을 두어야 하는 행
		
		if(!isAvailable(rowNo-1)) return; //-1한 이유: 이전까지 둔게 가능한건지 검사를 하는것임. 이런거 주의해야 함.
		
		//기본파트 : 퀸을 모두 놓았다면
		if(N+1 == rowNo) {
			ans++; //여기까지 왔다는 건 중간에 isAvailable()이 false가 된적이 없다는 것임.
			return;
		}
		
		//1열부터 - n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;//일단 놓고 
			setQueen(rowNo+1); //놓은게 가능하면 다음행으로 이동하도록
		}
	}
	
	public static boolean isAvailable(int rowNo) {
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) return false; //행이 겹치는 애 || 대각선
		}
		return true;
	}
}
