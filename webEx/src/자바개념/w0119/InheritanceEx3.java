package w0119;

class Branch {
	public Branch() {
		System.out.println("Branch default Constructor");          // 5
	}

	public Branch(String str, int a) {
		this();                                                    // 4
		System.out.println(str + " " + a + " Branch Constructor"); // 6
	}
}
class Leaf extends Branch {
	public Leaf(String str) {
		super(str, 10);                                            // 3
		System.out.println(str + " Leaf Constructor");             // 7
	}

	public Leaf() {
		this("ABC");                                               // 2
		System.out.println("Leaf default Constructor");            // 8
	}
}
public class InheritanceEx3 {
	public static void main(String[] args) {
		new Leaf();  // 1, 9
	}
}

//----------------------------------------------------------------
/*
class Branch{
	public Branch() {
		System.out.println("Branch default Constructor");
	}
	public Branch(String str) {
		this();
		System.out.println(str + " Branch Constructor");
	}
}
class Leaf extends Branch{
	public Leaf(String str) {
		super(str);
		System.out.println(str + " Leaf Constructor");
	}
}
public class InheritanceEx3 {
	public static void main(String[] args) {
		new Leaf("가나다");
	}
}
*/