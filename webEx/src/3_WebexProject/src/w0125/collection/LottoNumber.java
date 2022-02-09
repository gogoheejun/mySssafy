package w0125.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumber {
	public static void main(String[] args) {
		Set<Integer> lotto=new HashSet<>();
		
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);      // 1- 45사이의 수
		}
		
		List<Integer> lotto2=new ArrayList<>(lotto);
		Collections.sort(lotto2);
		
		for(Integer n: lotto2) {
			System.out.print(n + " ");
		}
	}
}
