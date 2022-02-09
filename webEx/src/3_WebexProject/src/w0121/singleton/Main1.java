package w0121.singleton;

//일반 객체
public class Main1 {
	public static void main(String[] args) {
		Speaker1 s1=new Speaker1();
		Speaker1 s2=new Speaker1();
		Speaker1 s3=new Speaker1();
		
		System.out.println(s1);  //or s1.toString()
		System.out.println(s2);
		System.out.println(s3);
		
		s1.setVolume(10);
		System.out.println(s1.getVolume());
		System.out.println(s2.getVolume());
		System.out.println(s3.getVolume());
		
		s2.setVolume(20);
		System.out.println(s1.getVolume());
		System.out.println(s2.getVolume());
		System.out.println(s3.getVolume());
	}
}
/*
w0121.singleton.Speaker1@2a139a55
w0121.singleton.Speaker1@15db9742
w0121.singleton.Speaker1@6d06d69c
10
5
5
10
20
5

*/