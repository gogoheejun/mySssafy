package ws0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*입력 : 
5
6 9 5 7 4

출력:
0 0 2 2 4
*/
public class Acmicpc2493_구미_5반_양희준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner로 하니까 메모리 초과떠서 BufferedReader로 변경
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		
		//탑의 높이를 담는 스택, 탑의 순서(인덱스)를 담는 스택
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		
		//처음을 넣어주고 시작- 넣고 뺄때엔 indexes스택도 함께 움직인다!
		heights.push(Integer.parseInt(inputs[0]));
		indexes.push(1);
		System.out.print("0"); //처음은 무조건 0
		
		for(int i=2; i<N+1; i++) {//첫번째 탑은 이미 넣었으므로 두번째부터 시작
			int now = Integer.parseInt(inputs[i-1]);
			int last = (int)heights.peek();
			//현재 탑이 스택의 탑보다 작은경우
			if(last > now) {
				System.out.print(" "+indexes.peek());
				heights.push(now);
				indexes.push(i);
				
			}else {
			//현재 탑이 스택의 탑보다 큰 경우
				int lastIndex = 0;
				while(true) {
					if(heights.isEmpty()) {//스택이 빈 경우는 현재 탑이 가장 높다는 것임
						System.out.print(" 0");
						break;
					}
					
					last = heights.pop();
					lastIndex = indexes.pop();
					if(last > now) {
						System.out.print(" "+lastIndex);
						break;
					}
				}
				//위 while문에서 마지막에 pop한것 다시 넣어주고, 현재 탑의 높이와 인덱스도 넣어줌
				indexes.push(lastIndex);
				indexes.push(i);
				heights.push(last);
				heights.push(now);
			}
			
		}
	}
	
}
