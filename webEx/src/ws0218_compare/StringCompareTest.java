package ws0218_compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompareTest {

	public static void main(String[] args) {
		String[] word = {"boy", "Cat", "Lion", "dog", "elephant", "i", "dragon", "Any", "giraffe", "animal", "Dogcat", "girl"};
		List<String> list = Arrays.asList(word);
		System.out.println("1. " + list);
		Collections.sort(list);
		System.out.println("2. "+list);

		
//		문자열 길이로 오름차순 정렬 후 사전 순 정렬
//		반대로 할땐 o2, o1순서 바꿔주면 됨
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o2.compareTo(o1);
				}
				return o2.length()- o1.length(); //o2,o1거꾸로 해보삼
			}
		});
		
		System.out.println("3. "+list);
	}
}
