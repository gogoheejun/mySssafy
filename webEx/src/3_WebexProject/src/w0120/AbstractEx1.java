package w0120;

//추상메서드가 없는 추상클래스----------------------------------
abstract class AA{
	public void view1() {}         //--1
	public void view2() {}         //--2
}
class BB extends AA{
	@Override
	public void view1() {}         //--3, 강제성이 없는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
//		AA ob=new AA();   // AA로 객체생성 불가능 
		
		AA ob2=new BB();
		ob2.view1();      // 3번
		ob2.view2();      // 2번
	}
}
//추상메서드가 있는 추상클래스----------------------------------
/*
abstract class AA{
	abstract public void view1();  //--1
	public void view2() {}         //--2
}
class BB extends AA{
	@Override
	public void view1() {}         //--3, 강제성이 있는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
//		AA ob=new AA();   // AA로 객체생성 불가능 
		
		AA ob2=new BB();
		ob2.view1();      // 3번
		ob2.view2();      // 2번
	}
}
*/
//일반 클래스--------------------------------------------
/*
class AA{
	public void view1() {}  //--1
	public void view2() {}  //--2
}
class BB extends AA{
	@Override
	public void view1() {}  //--3, 강제성이 없는 재정의
}
public class AbstractEx1 {
	public static void main(String[] args) {
		AA ob=new AA();   // AA로 객체생성가능 
		ob.view1();       // 1번 호출
		
		AA ob2=new BB();
		ob2.view1();      // 3번
		ob2.view2();      // 2번
	}
}
*/















