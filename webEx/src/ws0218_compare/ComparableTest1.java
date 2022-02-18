package ws0218_compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest1 {
	public static void main(String[] args) {
		
//1. primitive type의 경우 Arrays.sort()이용
		int[] num1 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		Arrays.sort(num1);
		int len = num1.length;
		System.out.print("0. [ ");
		for (int i = 0; i < len; i++) {
			System.out.print(num1[i]);
			if(i != len-1) System.out.print(", ");
			else System.out.println(" ]");
		}
		
		
		
		
//2. Integer와 같은 Wrapper클래스와 String, Date, File클래스들은 Comparable<T>이 구현되어 있다.
//		사전순 정렬(오름차순)
		Integer[] num2 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		
		List<Integer> numList = Arrays.asList(num2);
		Collections.sort(numList);//기본은 오름차순 정렬
		System.out.println("1. "+numList);
		
		Collections.reverse(numList);//내림차순 정렬
		System.out.println("2. "+numList);
		
		
		Collections.sort(numList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1.intValue() - o2.intValue();//오름차순
				return o2.intValue() - o1.intValue();//내림차순
			}
		});
		System.out.println("3. "+ numList);
	}
}
