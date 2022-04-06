import java.util.Scanner;

public class LISTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];//수열 원소저장
		int[] LIS = new int[N];//자신을 끝으로 하는LIS 길이
		
		for(int i=0 ;i<N; i++) {
			arr[i]= sc.nextInt();
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			LIS[i] = 1;//자신 혼자 LIS구성할때의 길이 1로 초기화
			for(int j=0; j<i; j++) {//첫원소부터 i원소 직전까지 비교
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {//arr[j]<arr[i]: 증가수열인지 확인....이 과정 반복되면 LIS[i]는 최댓값이 됨
					LIS[i] = LIS[j]+1;
				}
			}
			
			if(max<LIS[i]) max = LIS[i];
		}
		System.out.println(max);
	}
}
