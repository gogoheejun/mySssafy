package ws0203_1;

public class RecursiveTest3 {
	static int sum;
	
	public static void main(String[] args) {
		int[] arr= {1,3,5,7,9};
		System.out.println("배열의 합");
		for(int num: arr) {
			sum += num;
		}
		System.out.println(sum);
		
		sum=0;
		recur1(0, arr);
		
		recur2(0, arr, 0);	
	}
	
	private static void recur1(int n, int[] arr) {
		if(n==arr.length) {
			System.out.println(sum);
			return;
		}
		sum += arr[n];
		recur1(n+1, arr);
	}
	
	private static void recur2(int n, int[] arr, int hap) {
		if(n==arr.length) {
			System.out.println(hap);
			return;
		}
		hap += arr[n];
		recur2(n+1, arr, hap);
	}
}
