package w0118;

/*
클래스명 : UserInfo
+name:String   
+addr:String

+UserInfo()
+UserInfo(name:String, addr:String)   
+getter
*/
class UserInfo {
	   public String name;
	   public String addr;
	   
	   public UserInfo() {
	      System.out.println("** 주소록 **");
	   }
	   public UserInfo(String name, String addr) {
	      this();
	      this.name = name;
	      this.addr = addr;
	   }
	   public String getName() {
	      return name;
	   }
	   public String getAddr() {
	      return addr;
	   }
	}
public class ConstructorEx3 {
	public static void main(String[] args) {
		UserInfo ob=new UserInfo("도라에몽","구미시 인의동 100");
		System.out.println("이름:"+ob.getName());
		System.out.println("주소:"+ob.getAddr());
	}
}
/* [출력 화면] 
 ** 주소록 **          <---디폴트 생성자에서 출력
 이름 : 도라에몽                   <---main()함수에서 getter를 이용해서 출력
 주소 : 구미시 인의동 100
*/