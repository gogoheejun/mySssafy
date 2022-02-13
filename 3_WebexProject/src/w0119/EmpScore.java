package w0119;

//디폴트생성자, 인자4개받는 생성자, toString()추가
public class EmpScore extends Emp{
	private double score;
	private char grade;
	
	public EmpScore() {
		super();
	}
	
	public EmpScore(String name, String phone, double score, char grade) {
		super(name, phone);
		this.score=score;
		this.grade=grade;
	}
	
	@Override
	public String toString() {
		return super.toString()+
				"\n나의 점수는 " + score + "점 이고 학점은 " + grade +"입니다";
	}
}
