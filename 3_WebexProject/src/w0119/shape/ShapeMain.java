package w0119.shape;

public class ShapeMain {
	public static void main(String[] args) {
		Shape ob=new Rectangle(4,5);
		System.out.println("사각형의 넓이: " +ob.getSize());
		
		ob=new Triangle(3,7);
		System.out.println("삼각형의 넓이: " +ob.getSize());
		
		
//		Rectangle ob1=new Rectangle(4,5);
//		System.out.println("사각형의 넓이: " +ob1.getSize());
//		
//		Triangle ob2=new Triangle(3,7);
//		System.out.println("삼각형의 넓이: " +ob2.getSize());
	}
}
/*
사각형의 넓이: 20
삼각형의 넓이: 10.5
*/