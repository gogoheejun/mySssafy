package ws0218_car;

public class Taxi extends Car{
	int price;
	
	public Taxi() {
		super();
	}
	
	public Taxi(int carNum, String carName, int price) {
		super(carNum, carName);
		this.price = price;
	}
}
