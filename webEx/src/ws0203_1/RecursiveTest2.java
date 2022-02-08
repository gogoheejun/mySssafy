package ws0203_1;

public class RecursiveTest2 {
	public static void main(String[] args) {
		int[] arr= {1,3,5,7,9};
		recur(0, arr);
	}
	
	private static void recur(int n, int[] arr) {
		if(n==arr.length) {
			return;
		}
		System.out.print(arr[n]+"  ");
		recur(n+1, arr);
	}
}
//----------------------------------------------------------
/*
public class RecursiveTest2 {
	public static void main(String[] args) {
		int[] arr= {1,3,5,7,9};
		for(int val : arr) {
			System.out.print(val +"  ");
		}
	}
}
*/