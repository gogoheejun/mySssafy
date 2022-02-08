package ws0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		String opener = "<{([";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringBuilder sb = new StringBuilder();
			int answer = 1;
			sb.append("#").append(test_case).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			Stack<String> stack = new Stack<>();
			
			for(int i=0; i<N; i++) {
				String item = line.substring(i,i+1);
				
				if(opener.contains(item)) {
					stack.push(item);
					
				}else {
					if(!stack.isEmpty()) {
						String prev = stack.pop();
						boolean check = false;
						if(item.equals(">")&& prev.equals("<")) {
							check = true;
						}else if(item.equals("}")&& prev.equals("{")) {
							check = true;
						}else if(item.equals(")")&& prev.equals("(")) {
							check = true;
						}else if(item.equals("]")&& prev.equals("[")) {
							check = true;
						}
						if(!check) {
							answer = 0;
							break;
						}
					}
				}
				
			}
			sb.append(answer);
			System.out.println(sb);
		}
		
	}

}
