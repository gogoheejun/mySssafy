
public class MemberService {
	private static MemberService service;
	
	private MemberDao memberDao = MemberDao.getMemberDao();
	
	public static MemberService getMemberService() {
		if(service==null) {
			service = new MemberService();
		}
		return service;
	}
	
	public void registerMember(MemberDto memberDto) {
		dao.
	}
	
}
