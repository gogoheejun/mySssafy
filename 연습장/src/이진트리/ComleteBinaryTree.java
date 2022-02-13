package 이진트리;

import java.util.LinkedList;
import java.util.Queue;

public class ComleteBinaryTree {

	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public ComleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(char e) {
		
		if(isFull()) return;
		
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(1);
		
		while(!qu.isEmpty()) {
			int level = 0;
			System.out.print("level "+level+" : ");
			int size = qu.size();
			
			for(int i =0; i<size; i++) {
				int current = qu.poll();
				System.out.print(nodes[current]);
				if(current*2<=lastIndex) qu.offer(current*2);
				if(current*2+1<=lastIndex) qu.offer(current*2+1);
			}
			System.out.println();
			level++;
		}
	}
}
