package w0121.instanceofex;

class AA{}
class BB extends AA {}
class CC extends AA {}
public class InstanceofEx1 {
	public static void main(String[] args) {
		AA a=new AA();
		BB b=new BB();
		
		System.out.println(b instanceof AA);   // true
		System.out.println(a instanceof CC);   // false
//		System.out.println(b instanceof CC);   // error
	}
}
