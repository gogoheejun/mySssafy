package ws0210.prac;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public BinaryTree(int size) {
		nodes = new char[size+1]; // 1인덱스부터 사용하므로 +1크기로 잡기
		SIZE = size;
	}
	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(char e) {
		
		if(isFull()) return;
		
		nodes[++lastIndex] = e; //인덱스0은 비워뒀음.
	}
	
	public void bfs() {
		if(isEmpty()) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		while(!queue.isEmpty()) {
			int size = queue.size();
//			System.out.println();
			for(int i=0; i<size; i++) {
				int idx = queue.poll();
				System.out.print(nodes[idx]+" ");
				if(idx*2 <= lastIndex) queue.offer(idx*2);
				if(idx*2+1 <= lastIndex) queue.offer(idx*2+1);
			}
			System.out.println();
			
		}
	}
	
	public void predfs(int L) {
		if(L > lastIndex) return;
		
		System.out.print(nodes[L]+" ");
		predfs(L*2);
		predfs(L*2+1);
	}
}






















