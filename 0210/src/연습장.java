import java.util.LinkedList;
import java.util.Queue;

public class 연습장 {
	private char[] nodes;
	private int SIZE;
	private int lastIndex;
	
	public 연습장(int size) {
		nodes = new char[size + 1]; // 1인덱스부터 사용하므로 +1크기로 잡기
		SIZE = size;
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(char e) {

		if (isFull())
			return;
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if(isEmpty()) return;
		
		Queue<Integer> qu = new LinkedList<Integer>();
		
		qu.offer(1);
		int level = 0;
		while(!qu.isEmpty()) {
//			System.out.println(lever);
			
			int size = qu.size();
			while(--size>=0) {
				int current = qu.poll();
				System.out.println(nodes[current]);
			}
		}
	}
}










