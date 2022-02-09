import java.util.Arrays;
import java.util.Scanner;
/*
4 2
1 2 3 4
 */
public class 순조부 {


	static int N,R;
	static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
	static int[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permu(0, 0);
	}
	public static void permu(int cnt) {
		if(cnt == R) {
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i] == 1) continue;
			
			isSelected[i] = 1;
			numbers[cnt] = input[i];
			permu(cnt+1);
			isSelected[cnt] = 0;
		}
	}
	

}
