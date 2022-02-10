package ws0210.prac;


public class BinaryTreeTest {
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(9);
		char[] chars = {'a','b','c','d','e','f','g','h','i'};
		for(int i=0; i<9; i++) {
			tree.add(chars[i]);
		}
		tree.predfs(1);
	}
}
