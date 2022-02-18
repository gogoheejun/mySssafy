package ws0218_compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest2 {
	
	static void view(List<Car> list) {
		System.out.println("차번호\t차이름\t제조사");
		System.out.println("====================");
		for(Car car : list) {
			System.out.println(car);
		}
	}

	public static void main(String[] args) {
		Car car1 = new Car(2460, "SonataB", "HD");
		Car car2 = new Car(3488, "SonataC", "HD");
		Car car3 = new Car(1479, "Avante", "HD");
		Car car4 = new Car(6825, "K5", "KIA");
		Car car5 = new Car(6951, "SonataA", "HD");
		Car car6 = new Car(3910, "SM6", "SS");
		Car car7 = new Car(2136, "GENESIS", "HD");
		Car car8 = new Car(1306, "QM6", "SS");
		Car car9 = new Car(9667, "K7", "KIA");
		Car car10 = new Car(9668, "K5D", "KIA");
		
		List<Car> list = new ArrayList<>();
		list.add(car1);	 list.add(car2); 	list.add(car3);		list.add(car4);	 list.add(car5);  
		list.add(car6);  list.add(car7);	list.add(car8);		list.add(car9);  list.add(car10);		
		System.out.println("[정렬전]");
		view(list);
//---------------------------------------------------------------------------------------
//		Comparable<E>을 implements시 정렬 기준을 바꿔야 할 경우 override 한 compareTo()를 변경해야 한다.
//		차번호로 정렬에서 차이름으로 변경 할 경우. 또는 오름차순을 내림차순으로 변경할 경우. compareTo() 변경 불가피.
//		바뀌지 않는 기준을 이용해서 정렬할 경우 사용.
		System.out.println("\n[차번호로 내림차순 정렬]"); //Car.java에 가서 Comparable을 상속했다.
		
		Collections.sort(list);
		
		view(list);
		
//---------------------------------------------------------------------------------------		
//		Comparator는 특정한 그때그때 정렬하는 기준을 정해야 하는경우
//		compareTo()를 매번 변경 할 수 없으므로 단발성이나 다양한 기준을 세우고 싶은 경우 사용.
		System.out.println("\n[차번호로 오름차순 정렬]");
		
		Comparator<Car> carNameComparator = new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				return o1.getCarNum() - o2.getCarNum();
			}
		};
		Collections.sort(list, carNameComparator);
		view(list);
//-----------------------------------------------------------------------------------------		
		System.out.println("\n[제조사로 내림차순 정렬]");
		
		Comparator<Car> carMakerComparator = new Comparator<Car>() {

//			@Override
//			public int compare(Car o1, Car o2) {
//				return o1.getMaker().charAt(0) - o2.getMaker().charAt(0);
//			}
			@Override
	         public int compare(Car o1, Car o2) {
	            return o2.getMaker().compareTo(o1.getMaker());
	         }
		};
		
		Collections.sort(list, carMakerComparator);
		view(list);
	}
}
