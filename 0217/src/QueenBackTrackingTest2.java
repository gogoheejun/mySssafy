import java.util.Scanner;

/*
 * 이 방법은 QueenBackTrackingTest와 거의 똑같음. 유망성 검사먼저 하고 재귀로 보는지, 재귀보내고 그 담에 유망성검사사하는지만 다를 뿐임
 * 난 이게 더 직관적이네ㅎㅎ
 */
public class QueenBackTrackingTest2 {
	
	static int N;
	static int col[];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];//0은 안씀
		ans = 0;
		
		setQueen(1);//사실 1넣기 전에 0이 가능한지 검사해야하는데, 여기선1 무조건 가능하니까 걍 이렇게 고했음.
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) {//rowNo: 퀸을 두어야 하는 행
				
		//기본파트 : 퀸을 모두 놓았다면
		if(N+1 == rowNo) {
			ans++; //여기까지 왔다는 건 중간에 isAvailable()이 false가 된적이 없다는 것임.
			return;
		}
		
		//1열부터 - n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;//일단 놓고 
			if(isAvailable(rowNo)) {
				setQueen(rowNo+1); //놓은게 가능하면 다음행으로 이동하도록
			}
		}
	}
	
	public static boolean isAvailable(int rowNo) {
		
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) return false; //행이 겹치는 애 || 대각선
		}
		return true;
	}
}
