package w0119.shape;

/*  
클래스명:Triangle => Shape를 상속받음
  +Triangle()
  +Triangle(data1:int , data2:int)
  +getSize():double            ==>삼각형의 넓이를 리턴(밑변 * 높이 /2) 
*/
public class Triangle extends Shape{
	public Triangle() {
		super();
	}

	public Triangle(int data1, int data2) {
		super(data1, data2);
	}
	
	@Override
	public double getSize() {
		return (double)super.getData1() * super.getData2()/2;
	}
}
