package w0120;

abstract class Shape{
	abstract public void draw();
	abstract public void erase();
}
//------------------------------------------------
class Rectangle extends Shape{
	@Override
	public void draw() {
		System.out.println("사각형을 그린다");
	}
	@Override
	public void erase() {
		System.out.println("사각형을 지운다");
	}
}
//------------------------------------------------
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("원을 그린다");
	}
	@Override
	public void erase() {
		System.out.println("원을 지운다");
	}
}
//------------------------------------------------
public class AbstractEx2 {
	public static void main(String[] args) {
		Shape ob=new Rectangle();
		ob.draw();
		ob.erase();
		
		ob=new Circle();
		ob.draw();
		ob.erase();
	}
}
