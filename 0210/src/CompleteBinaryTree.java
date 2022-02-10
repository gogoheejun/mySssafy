import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;// 트리에 문자저장할거임
	private int SIZE;
	private int lastIndex;// 마지막에 추가된 인덱스 관리

/*
  	  A
 	B	C
   D E F G
  H I
  
 */
	public CompleteBinaryTree(int size) {
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
		nodes[++lastIndex] = e;//인덱스 0 비워뒀음.
	}

	public void bfs() {

		if (isEmpty())
			return; // 공백트리면 할거없음

		// 이진트리의 탐색순서
		Queue<Integer> qu = new LinkedList<>();

		// 루트가 가장 먼저 탐색되도록 qu에 넣기
		qu.offer(1);
		while (!qu.isEmpty()) {
			int current = qu.poll(); // 탐색순서에 맞는 인덱스

			System.out.println(nodes[current]);

			// 현재 노드의 자식노드드르이 인덱스를 다음에 자기순서가 됐을 때 탐색되도록 큐에 넣음
			// 지금 가정하고 있는 트리가 완전트리라서 가능한거임
			// 왼쪽 자식노드 : current*2
			if (current * 2 <= lastIndex)
				qu.offer(current * 2);
			// 오른쪽 자식노드: current*2 +1
			if (current * 2 + 1 <= lastIndex)
				qu.offer(current * 2 + 1);

		}

	}

	public void bfs2() {

		if (isEmpty())
			return; // 공백트리면 할거없음

		// 이진트리의 탐색순서
		Queue<Integer> qu = new LinkedList<>();

		// 루트가 가장 먼저 탐색되도록 qu에 넣기
		qu.offer(1);//0넣으면 곱해도 계속 0이라 무한반복됨...
		int level = 0;
		while (!qu.isEmpty()) {
			System.out.print("level "+level+" : ");
			//같은너비의 노드들 모두 탐색, 같은 행에 출력
			int size = qu.size();
			while(--size >= 0) {
				int current = qu.poll(); // 탐색순서에 맞는 인덱스

				System.out.print(nodes[current]+"\t");

				// 현재 노드의 자식노드드르이 인덱스를 다음에 자기순서가 됐을 때 탐색되도록 큐에 넣음
				// 지금 가정하고 있는 트리가 완전트리라서 가능한거임- 지금 이부분은 완전트리에 종속적인거라 다른곳에선 다르게 구현됨
				// 왼쪽 자식노드 : current*2
				if (current * 2 <= lastIndex)
					qu.offer(current * 2);
				// 오른쪽 자식노드: current*2 +1
				if (current * 2 + 1 <= lastIndex)
					qu.offer(current * 2 + 1);
			}
			System.out.println();
			++level;
		}

	}
	//-------DFS
	public void dfsByBreOrder() {
		System.out.println();
		dfsByBreOrder(1);//오버로딩-이렇게 하면 밖에서 dfs부를때 항상 시작점을 1로 시작할 수 있게 됨.
		System.out.println();
	}
	public void dfsByInOrder() {
		System.out.println();
		dfsByInOrder(1);//오버로딩-이렇게 하면 밖에서 dfs부를때 항상 시작점을 1로 시작할 수 있게 됨.
		System.out.println();
	}
	public void dfsByPostOrder() {
		System.out.println();
		dfsByPostOrder(1);//오버로딩-이렇게 하면 밖에서 dfs부를때 항상 시작점을 1로 시작할 수 있게 됨.
		System.out.println();
	}
//---dfsprivate함수들
	private void dfsByBreOrder2(int current) {
		//현재 노드 방문
		System.out.print(nodes[current]+"\t");
		//현재노드의 자식노드들 방문
		
		if(current*2 <= lastIndex) dfsByBreOrder(current*2);
		if(current*2+1 <= lastIndex) dfsByBreOrder(current*2+1);
	}
	//위랑 똑같은건데 아래처럼하면 기저조건이 좀더 잘 보이는듯
	private void dfsByBreOrder(int current) {
		if(current > lastIndex) return;
		//현재 노드 방문
		System.out.print(nodes[current]+"\t");
		//현재노드의 자식노드들 방문
		
		dfsByBreOrder(current*2);
		dfsByBreOrder(current*2+1);
	}
	
	private void dfsByInOrder(int current) {
		if(current > lastIndex) return;
		
		//현재노드의 자식노드들 방문
		
		dfsByBreOrder(current*2);
		//현재 노드 방문
		System.out.print(nodes[current]+"\t");
		dfsByBreOrder(current*2+1);
	}
	
	private void dfsByPostOrder(int current) {
		if(current > lastIndex) return;
		
		//현재노드의 자식노드들 방문
		
		dfsByBreOrder(current*2);
		dfsByBreOrder(current*2+1);
		
		//현재 노드 방문
		System.out.print(nodes[current]+"\t");
	}
}
