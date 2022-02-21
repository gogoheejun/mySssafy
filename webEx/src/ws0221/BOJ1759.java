package ws0221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1759 {
	static int L, C;
	static char[] inputs;
	static boolean[] isUsed;
	static char[] password;
	static List<String> ans = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); //비밀번호자릿수
		C = sc.nextInt();
		isUsed = new boolean[C];
		inputs = new char[C];
		password = new char[L];
		for(int i=0; i<C; i++) {
			inputs[i] = sc.next().charAt(0);
		}
		
		getPassword(0);
		Collections.sort(ans);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	

	static void getPassword(int cnt) {
		if(cnt == L) {
			//모음, 자음 체크
			List<Character> moList = Arrays.asList('a','e','i','o','u');
			int mo = 0;
			int ja = 0;
			for(int i=0; i<L; i++) {
				if(moList.contains(password[i])) mo++;
				else ja++;
			}
			if(mo<1|| ja<2) return;
			//
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<L; i++) {
				sb.append(password[i]);
			}
			ans.add(sb.toString());
			return;
		}
		for(int i=0; i<inputs.length; i++) {
			if(isUsed[i]) continue;
			//오름차순인지 체크
			if(!checkPassword(inputs[i], cnt-1)) continue;
			isUsed[i] = true;
			password[cnt] = inputs[i];
			getPassword(cnt+1);
			isUsed[i] = false;
		}
	}
	
	static boolean checkPassword(char ch, int cnt){
		if(cnt<0) return true;
		char lastWord = password[cnt];
		
		if(lastWord-ch <0) {//오름차순
			return true;
		}else {
			return false;
		}
	}
}

