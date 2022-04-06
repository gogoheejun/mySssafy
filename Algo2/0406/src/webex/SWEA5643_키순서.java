package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643_키순서 {
	
	static int N, M;
	static List<Integer>[] big;
	static List<Integer>[] small;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int c=1; c<=T; c++) {
			N = Integer.parseInt(br.readLine()); //학생들 수
			M = Integer.parseInt(br.readLine()); //비교 횟수
			big = new ArrayList[N+1];
			small = new ArrayList[N+1]; //..배열 초기화
			for(int i=0; i<=N; i++) {
				big[i] = new ArrayList<Integer>();
				small[i] = new ArrayList<Integer>();
			} //..리스트 초기화
			
			for(int i=0; i<M ;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int smallNum = Integer.parseInt(st.nextToken());
				int bigNum = Integer.parseInt(st.nextToken());
				big[smallNum].add(bigNum);//smallNum보다 큰애들은 big[smallNum]에 다 있음.
				small[bigNum].add(smallNum);//bigNum보다 큰애들은 small[bigNum]에 다 있음.
			}
			
			int result = 0;
			for(int i=1; i<=N; i++) {
				int mycnt = count(i);
				if(mycnt == N-1) result++;
			}
			System.out.println("#"+c+" "+result);
		}
	}
	
	static int count(int num) {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(num);
		boolean visited[] = new boolean[N+1];
		visited[num] = true;
		int cnt = 0;
		while(!qu.isEmpty()) {
			int now = qu.poll();
			for(int i:big[now]) {
				if(visited[i]) continue;
				visited[i] = true;
				cnt++;
				qu.offer(i);
			}
		}
		qu.offer(num);
		while(!qu.isEmpty()) {
			int now = qu.poll();
			for(int i:small[now]) {
				if(visited[i]) continue;
				visited[i] = true;
				cnt++;
				qu.offer(i);
			}
		}
		
		return cnt;
	}

}
