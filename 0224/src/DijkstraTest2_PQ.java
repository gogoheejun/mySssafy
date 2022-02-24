import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2_PQ {
	static class Vertex implements Comparable<Vertex>{
		int no, minDistance; //정점번호, 출발지에서 "자신"으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		StringTokenizer st = null;
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V]; //나한테 오는 최소비용. 어디어디 거쳤든간에 출발점->나한테 오는 최소비용.
		boolean[] visited = new boolean[V]; //최소비용 확정여부
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Vertex(start, 0));
		
		while(!pQueue.isEmpty()) {
			//단계1. 최소비용 확정안된 정점들 중 가장 작은 애 선택(pq쓰니까 poll하면 자도응로 됨)
			Vertex current = pQueue.poll();
			//pq에 vertex같은애라도 비용이 다르면 계속 pq에 넣었어가지고 같은 vertex가 poll될 수 있음. 
			//근데 사실은 continue안해도 비용이 크면 업뎃어차피 안됨 distance[j] > distance[current.no]+adjMatrix[current.no][j] 이거때매)
			if(visited[current.no]) continue;
			visited[current.no] = true;
			
			//단계2: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용들 업뎃해줌
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjMatrix[current.no][j]!=0 
						&& distance[j] > distance[current.no]+adjMatrix[current.no][j]) {
					
					distance[j] =  distance[current.no]+adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));//j가 같은애 여러번 들어가도 어차피 작은애가 위로 올라감.(공간복잡도 따위 별 상관없음 여기선.)
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		
	}

}







