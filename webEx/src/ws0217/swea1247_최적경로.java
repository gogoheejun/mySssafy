package ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/*
1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20 //200

1
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14 //304


 */
public class swea1247_최적경로 {
	
	static class Client implements Comparable<Client>{
		int x;
		int y;
		
		public Client(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Client o) {
			int diff = this.x - o.x;
			return (diff!=0)?diff:this.y-o.y;
		}
		
		@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "x: "+x +", y: "+y;
			}
	}

	static List<Client> clientsA = new ArrayList<Client>();
	static List<Client> clientsB = new ArrayList<Client>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x < startX) {
					clientsA.add(new Client(x,y));
				}else {
					clientsB.add(new Client(x,y));
				}
				
			}
			Collections.sort(clientsA, Collections.reverseOrder());
			Collections.sort(clientsB);
			
			int sumA = 0;
			int sumB = 0;
			if(clientsA.size()>0) {
				sumA += Math.abs(startX-clientsA.get(0).x) + Math.abs(startY- clientsA.get(0).y);
				
				if(clientsB.size()>0) {
					sumA += Math.abs(clientsA.get(clientsA.size()-1).x - clientsB.get(0).x)+
							Math.abs(clientsA.get(clientsA.size()-1).y - clientsB.get(0).y);
				}
			}
			
			for(int i=1; i<clientsA.size(); i++) {
				int diff = Math.abs(clientsA.get(i).x-clientsA.get(i-1).x) +  Math.abs(clientsA.get(i).y-clientsA.get(i-1).y);
				sumA += diff;
			}
			
			//
			for(int i=1; i<clientsB.size(); i++) {
				int diff = Math.abs(clientsB.get(i).x-clientsB.get(i-1).x) +  Math.abs(clientsB.get(i).y-clientsB.get(i-1).y);
				sumB += diff;
			}
			sumB += Math.abs(endX-clientsB.get(clientsB.size()-1).x) + Math.abs(endY- clientsB.get(clientsB.size()-1).y);
			
			System.out.println(sumA + sumB);
		}
		System.out.print(sb.toString());
	}
	
	

}
