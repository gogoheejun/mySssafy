package 이진트리;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		int size = 9;
		
		ComleteBinaryTree tree = new ComleteBinaryTree(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)(65+i)); // A,B,C,D ...
		}
		
		tree.bfs();
	}
}
