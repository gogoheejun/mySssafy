package ws0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();//노드번호 패스
				char first = st.nextToken().charAt(0);
				//리프노드 아닐때
				if(st.hasMoreTokens()) {
					if(first)
				}else {//리프노드일때
					//숫자라면
					if(first<'0' || first>'9') {
						System.out.println("# "+tc+" "+0);
					}
				}
			}
		}
	}

}
