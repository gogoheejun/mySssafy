package w0124;

public class Test3 {
	public void execute(String msg) {
		int[] co = new int[10];
		int len = msg.length();
		for (int i = 0; i < len; i++) {
			co[msg.charAt(i) - '0']++;
		}
		for (int i = 0; i < co.length; i++) {
			if (co[i] == 0)
				continue;
			System.out.println(i + " : " + co[i]);
		}
	}

	public static void main(String[] args) {
		Test3 c = new Test3();
		c.execute("53290539955364534323455987827332679340558347453272569584");
		System.out.println("=======");
		c.execute("13334444555557777777");
	}
}
