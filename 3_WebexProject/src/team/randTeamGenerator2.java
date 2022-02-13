package team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class randTeamGenerator2 {
	public static void main(String[] args) throws Exception {
		// input.txt 사용해서 만들려는 경우에 사용
		/*
		 * String path = randTeamGenerator.class.getResource("").getPath(); Scanner sc =
		 * new Scanner(new FileInputStream(path + "input.txt")); ArrayList<String> list
		 * = new ArrayList<String>(); Random rand = new Random();
		 * 
		 * 
		 * while(sc.hasNextLine()) list.add(sc.nextLine());
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("권도현");list.add("권성호");list.add("김상영");list.add("김주영");
		list.add("김주원");list.add("김지혜");list.add("김필재");list.add("김효선");
		list.add("류인석");list.add("박자연");list.add("박지현");list.add("박한훈");
		list.add("변수경");list.add("복성범");list.add("신예인");list.add("이기종");
		list.add("이대희");list.add("이명범");list.add("이상민");list.add("이재환");
		list.add("이정재");list.add("전효인");list.add("정동규");
		list.add("조인후");list.add("최영희");list.add("한제규");
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int member = list.size();
		for (int i = 0; i < member / n + 1; i++) {
			System.out.println((i + 1) + "조 ------------------");
			int num;
			for (int j = 0; j < n; j++) {
				if (list.size() <= 0) {
					break;
				}
				num = rand.nextInt(list.size());
				System.out.println(list.get(num));
				list.remove(num);
			}
		}
	}
}
