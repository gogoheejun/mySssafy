package w0126.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaEx7 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("월");
		list.add("화");
		list.add("수");
		list.add("목");
		list.add("금");
		
		for(String m:list) {
			System.out.println(m);
		}
		System.out.println("------------");
		list.forEach((m)->System.out.println(m+"요일"));
		// void java.lang.Iterable.forEach(Consumer<? super String> action)
		
		System.out.println("------------");
		Collections.sort(list);
		list.forEach((m)->System.out.println(m));
	}
}
