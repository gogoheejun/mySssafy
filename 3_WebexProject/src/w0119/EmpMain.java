package w0119;

public class EmpMain {
	public static void main(String[] args) {
		Emp ob1=new Emp("이순신","010-1111-1111");
		System.out.println(ob1);
		
		EmpScore ob2=new EmpScore("강호동","010-1234-5678",75.3,'C');
		System.out.println(ob2);
	}
}
/*
나의 이름은 이순신이고 연락처는 010-1111-1111입니다

나의 이름은 강호동이고 연락처는 010-1234-5678입니다
나의 점수는 75.3점 이고 학점은 C입니다
*/