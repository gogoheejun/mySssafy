package test;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String id;
		String pw;
		
		System.out.print("ID를 입력하시오:");  id=sc.next();
		System.out.print("PW를 입력하시오:");  pw=sc.next();
		
		UserProc up=new UserProc();
		User entity=up.getLoginUser(id,pw);
		
		if(entity==null) {
			System.out.println("ID 또는 PW가 틀리거나 존재하지 않는 ID입니다");
		}else {
			System.out.println("뽀로로님이 입장하셨습니다");
			System.out.println("현재포인터는 "+entity.getPoint()+"점 입니다" );
			System.out.println();
			System.out.println("[[BOOk의 정보보기]]");
			
			BookProc BookEntity = new BookProc();
			ArrayList<Book> bList = BookEntity.getList();
			for(int i=0; i<bList.size();i++) {
				System.out.println("책이름: "+bList.get(i).getTitle()+"\t 책저자: "+bList.get(i).getAuthor()+"\t 페이지: "+bList.get(i).getPage());
			}
			
		}
		
				
	}
}
/* [문제1]
 * ID를 입력하시오 : pororo
 * PW를 입력하시오 : 1234
 * 뽀로로님이 입장하셨습니다
 * 현재포인터는 89.97점 입니다
 *
 *
 * ID를 입력하시오 : pororo
 * PW를 입력하시오 : 1235
 * ID 또는 PW가 틀리거나 존재하지 않는 ID입니다
 * -----------------------------------------------------
 * [문제2]
 * ID를 입력하시오 : pororo
 * PW를 입력하시오 : 1234
 * 
 * 뽀로로님이 입장하셨습니다
 * 현재포인터는 89.97점 입니다
 * 
 * [[BOOk의 정보보기]]
 * 책이름:JAVA    책저자:kim      페이지: 100
 * 책이름:C++     책저자:lee       페이지: 250
 * 책이름:JSP      책저자:park     페이지: 150
 * 
 */
