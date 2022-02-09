package w0120.interfaceex;

//인터페이스-----------------------------------------------
interface Shape {
	int r = 10;
	public void draw();
	public void erase();
}
class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("반지름이 " + r + "인 원을 그린다");
	}
	@Override
	public void erase() {
		System.out.println("원을 지운다");
	}
}
public class InterfaceEx1 {
	public static void main(String[] args) {
		Circle ob = new Circle();
		ob.draw();
		ob.erase();
	}
}
//추상클래스-----------------------------------------------
/*
abstract class Shape{
	final int r=10;
	abstract public void draw();
	abstract public void erase();
}
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("반지름이 " + r +"인 원을 그린다");
	}
	@Override
	public void erase() {
		System.out.println("원을 지운다");
	}
}
public class InterfaceEx1 {
	public static void main(String[] args) {
		Circle ob=new Circle();
		ob.draw();
		ob.erase();
	}
}
*/
//일반클래스-----------------------------------------------
/*
class Shape{
	final int r=10;
	public void draw() {}
	public void erase() {}
}
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("반지름이 " + r +"인 원을 그린다");
	}
	@Override
	public void erase() {
		System.out.println("원을 지운다");
	}
}
public class InterfaceEx1 {
	public static void main(String[] args) {
		Circle ob=new Circle();
		ob.draw();
		ob.erase();
	}
}
*/
