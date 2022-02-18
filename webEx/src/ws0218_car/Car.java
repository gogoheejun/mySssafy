package ws0218_car;

import java.io.Serializable;

public class Car implements Serializable{
	private int carNum;
	private String carName;
	
	public Car() {
	}
	
	public Car(int carNum, String carName) {
		super();
		this.carNum = carNum;
		this.carName = carName;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Car [carNum= "+carNum+", carName= "+carName+"]";
	}
}
