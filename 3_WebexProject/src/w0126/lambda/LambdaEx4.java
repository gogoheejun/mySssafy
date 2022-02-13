package w0126.lambda;

@FunctionalInterface
interface Ver{
	public String call(String v);    
}
public class LambdaEx4 {
	public static void main(String[] args) {
		Ver vv=(s) -> (s.equals("자바")?"ver 8.0":"ver 5.0");
		System.out.println("자바 " + vv.call("자바"));
		System.out.println("스프링 " + vv.call("스프링"));
		System.out.println();
		//-----------------------------------------------------------------
		Ver m1=(v)->{
			return "Java " + v;       // 또는  Ver m1=(v)-> "Java " + v;
		};
		System.out.println(m1.call("ver 8.0"));
		
		Ver m2=(v)-> "Spring " + v;
		System.out.println(m2.call("ver 5.0"));		
	}
}
