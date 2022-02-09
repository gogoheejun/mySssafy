package w0126.lambda;


//람다식형태------------------------
@FunctionalInterface
public interface Print {  // 자바함수형 interface, 람다식으로 사용할 것을 선언
	public void view();   // 함수는 반드시 1개
}


//일반메서드 형태, 익명중첩클래스--------
/*
public interface Print {
	public void view(); 
}
*/
