package 스택;

public class Stack {
	Node top;
	
	public void push(String data) {
		top = new Node(data, top);
	}
	
	public Node pop() {
		Node popnode = top;
		top = popnode.link;
		return popnode;
	}
}
