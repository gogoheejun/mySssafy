package ws0214.professor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[입력]
1
1 3

[출력]
#1 0 2
*/
public class Solution_D3_6808_규영이와인영이의카드게임_nextpermutation {
	static int win, lose;
	static int[] numbers1, numbers2;
	static int N=2;
	static boolean []visited;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("src/ws0214/s_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		numbers1 = new int[N];             //규영이 카드저장 배열
		numbers2 = new int[N];             //인영이 카드저장 배열
		String line;
		StringTokenizer st ;
		int[] card = new int[5];          //0~18 중  1번지~18번지까지 사용
		visited = new boolean[5];         //방문체크
		
		int data;
		for (int tc = 1; tc <= T; tc++) {
			line = in.readLine();
			st = new StringTokenizer(line.trim());
			
			for (int i = 0; i <N; i++) {
				data = Integer.parseInt(st.nextToken());
				card[data] = 1;             //규영이 받은 9장의 카드를 카드배열에  1로표시
				numbers1[i] = data;         //규영이 받은 숫자 저장
			}
			data=0;
			for (int i = 1; i <card.length; i++) {
				if(card[i]==0) {
					numbers2[data++]= i;    //인영이 받은 숫자 저장
				}
			}
			
//			for(int i=0; i<3; i++)
//				System.out.print(numbers1[i]+" ");
//			System.out.println();
//			for(int i=0; i<3; i++)
//			    System.out.print(numbers2[i]+" ");
//			System.out.println("\n");

			dfs(0, 0, 0);                  //비교수(9), 규영이합, 인영이합
			System.out.println("#"+tc+" "+win+" "+lose);
			
			//다음 테스트케이스를 위한 초기화
			win=0;
			lose=0;
			Arrays.fill(card, 0);          //Arrays.fill(): 배열의 모든 값을 같은 값으로 초기화하는 메서드
		}
	}
	public static void dfs(int cnt, int guSum, int inSum) {
		if(cnt == N) {
			if(guSum > inSum) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		
		int guCard, inCard;		
		for (int i = 1; i <= N; i++) {
			if(visited[i])continue;
			
			 visited[i]=true;			
			 guCard = numbers1[cnt];  
			 inCard = numbers2[i-1];  
			 
			 if(guCard>inCard) {
				 dfs(cnt+1, guSum+inCard+guCard, inSum);
			 }else {
				 dfs(cnt+1, guSum, inSum+inCard+guCard);
			 }
			 visited[i]=false;
		}//for
	}//dfs
}