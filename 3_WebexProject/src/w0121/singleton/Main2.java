package w0121.singleton;

public class Main2 {
	public static void main(String[] args) {
		Speaker2 s1 = Speaker2.getInstance();
		Speaker2 s2 = Speaker2.getInstance();
		Speaker2 s3 = Speaker2.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println(s1.getVolume());
		System.out.println(s2.getVolume());
		System.out.println(s2.getVolume());
		
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
w0121.singleton.Speaker2@2a139a55
w0121.singleton.Speaker2@2a139a55
w0121.singleton.Speaker2@2a139a55
5
5
5
10
10
10
20
20
20

*/