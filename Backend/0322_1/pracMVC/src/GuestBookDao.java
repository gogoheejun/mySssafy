import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ssafy.guestbook.model.GuestBookDto;

public class GuestBookDao {
	private DBUtil dbUtil = DBUtil.geInstance();
	
	private static GuestBookDao guestBookDao;
	
	public static GuestBookDao getGuestBookDao() {
		return guestBookDao;
	}
	
	public void registerArticle(GuestBookDto guestBookDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into guestbook (userid, subject, content, regtime"
		}
	}
}
