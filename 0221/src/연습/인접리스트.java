package 연습;
/*
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6

그래프로 그려보면,
  0
 / \ 
1   2
|\ /
3 4
\ |
 5 
 |
 6

 */

//무향그래프
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인접리스트 {
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 정점 수
		int C = sc.nextInt();// 간선 수
		Node[] nodeArr = new Node[N];
		
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			nodeArr[from] = new Node(to, nodeArr[from]);
			nodeArr[to] = new Node(from, nodeArr[to]);
		}
		
		bfs(0,nodeArr);
	}
	
	static void bfs(int start, Node[] nodeArr) {
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		qu.offer(start);
		visited[start] = true;
		while(!qu.isEmpty()) {
			int current = qu.poll();
			System.out.println(current);
			for(Node temp = nodeArr[current]; temp != null; temp = temp.link ) {
				if(!visited[temp.vertex]) {
					qu.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
}















