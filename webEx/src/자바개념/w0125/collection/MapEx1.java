package w0125.collection;

import java.util.HashMap;
import java.util.Map;

public class MapEx1 {
	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<>();
		map.put(101, "둘리");
		map.put(104, "도우넛");
		map.put(102, "마이콜");
		map.put(103, "또치");
		
		System.out.println("key: "+ 101 +"   value: " + map.get(101));
		System.out.println("key: "+ 102 +"   value: " + map.get(102));
		System.out.println("key: "+ 103 +"   value: " + map.get(103));
		System.out.println("key: "+ 104 +"   value: " + map.get(104));
		//------------------------------------------------------------------
/*		Map map=new HashMap();
		map.put(101, "둘리");
		map.put(104, "도우넛");
		map.put(102, "마이콜");
		map.put(103, "또치");
		
		System.out.println("key: "+ 101 +"   value: " + map.get(101));
		System.out.println("key: "+ 102 +"   value: " + map.get(102));
		System.out.println("key: "+ 103 +"   value: " + map.get(103));
		System.out.println("key: "+ 104 +"   value: " + map.get(104));*/
	}
}
