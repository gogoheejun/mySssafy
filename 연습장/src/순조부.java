import java.util.Arrays;
import java.util.Scanner;
/*
4 2
1 2 3 4
 */
public class 순조부 {


	static int N,R;
	static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
	static int[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		selected = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
//		permu(0);
//		combi(0,0);
		subset(0);
	}
	
	public static void permu(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
		}
		for(int i=0; i<N; i++) {
			if(selected[i] == 1) continue;
			
			selected[i] = 1;
			numbers[cnt] = i;
			permu(cnt+1);
			selected[i] = 0;
		}
	}
	
	public static void combi(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
		}
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];
			combi(cnt+1, i+1);
		}
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				System.out.print(selected[i]==1?input[i]:"X");
			}
			System.out.println();
			return;
		}
		selected[cnt] = 1;
		subset(cnt+1);
		selected[cnt] = 0;
		subset(cnt+1);
	}
}
