import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class DijkstraTest2_PQ_List {
	static class Node{
		int vertex,weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		
		int start = 0;
		
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, dist, adjList[from]);
		}
		
		int[] distance = new int[V]; //나한테 오는 최소비용. 어디어디 거쳤든간에 출발점->나한테 오는 최소비용.
		boolean[] visited = new boolean[V]; //최소비용 확정여부
				
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		int min=-1, current=-1;//임시로 초기화
		for(int i=0; i<V; i++) {//i는 의미없음 V번 돈다는데 의미.
			min = Integer.MAX_VALUE; 
			for(int j=0; j<V; j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];//제일처음에 distance[0]만 여기로 오는데, 이때 min = 0이 된다.
					current = j;//갈수 있는 애들 중에 젤 가까운 정점이 j다!(출발할땐 당근 0임)
				}
			}
			
			visited[current] = true;
//			if(current == end) break;
			
			//여기서 temp란 current정점 담에 갈수있는 애들임.
			for(Node temp = adjList[current]; temp!= null; temp = temp.next) {
				if(!visited[temp.vertex] 
						&& distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		
	}

}







