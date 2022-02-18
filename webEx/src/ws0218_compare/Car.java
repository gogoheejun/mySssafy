package ws0218_compare;

public class Car implements Comparable<Car>{

	private int carNum;
	private String carName;
	private String maker;
	
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return o.getCarNum()-this.carNum;
	}

	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return carNum + "\t" + carName + "\t" + maker;
	}
}
