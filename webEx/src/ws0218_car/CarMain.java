package ws0218_car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarMain {
	public static void main(String[] args) {
		CarManager carManager = CarManagerImpl.getInstance();
		System.out.println("[자동차 등록하기]");
		try {
			carManager.add(new Car(1111,"쏘나타"));
			
			carManager.add(new Car(2222,"제네시스"));
			carManager.add(new Taxi(3333,"쏘나타",3500));
//			carManager.add(new Car(1111,"쏘나타"));//중복번호 등록
			carManager.add(new Car(4444,"K5"));
		}catch (SameNumberException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		//-----------------------------
		System.out.println("[자동차목록보기]...SameNumberException연습");
		List<Car> list = carManager.search();
		for(Car car: list) {
			System.out.println(car);
		}
		
		System.out.println();
		//-------------------------------
		System.out.println("[번호로 검색하기]...NotFoundException연습");
		try {
			Car foundCar = carManager.SearchByNumber(5555);
			System.out.println(foundCar);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		//------------------------------
		//car.txt를 저장
		carManager.save();
		System.out.println("car.txt를 저장했습니다.\n");
		//car.txt 불러오기
		System.out.println("car.txt 불러오기");
		List<Car> carList = carManager.load();
		for(Car c: carList) {
			System.out.println(c);
		}
	
	}
}
