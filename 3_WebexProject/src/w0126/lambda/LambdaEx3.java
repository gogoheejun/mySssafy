package w0126.lambda;

//람다식--------------------------------------------------
@FunctionalInterface
interface Item {
   public String getItem();
}
public class LambdaEx3 {
   public static void main(String[] args) {
      Item ob=()->"컴퓨터";           //or  Item ob = ()-> {return "컴퓨터";};
      System.out.println(ob.getItem());
   }
}
//익명함수-------------------------------------------------
/*
interface Item {
	public String getItem();
}
public class LambdaEx3 {
	public static void main(String[] args) {
		Item m = new Item() {
			@Override
			public String getItem() {
				return "컴퓨터";
			}
		};
		System.out.println(m.getItem());
	}
}
*/
//일반메서드-----------------------------------------------
/*
interface Item{
	public String getItem();
}
public class LambdaEx3 implements Item{
	@Override
	public String getItem() {
		return "컴퓨터";
	}
	public static void main(String[] args) {
		LambdaEx3 ob=new LambdaEx3();
		System.out.println(ob.getItem());
	}
}
*/