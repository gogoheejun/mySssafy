package 스택;

public class Node {
	String data;
	Node link;
	
	public Node(String data) {
		this.data = data;
	}
	public Node(String data, Node link) {
		this.data = data;
		this.link = link;
	}
}
