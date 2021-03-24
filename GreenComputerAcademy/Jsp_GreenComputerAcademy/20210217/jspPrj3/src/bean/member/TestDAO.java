package bean.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TestDAO{
	HttpSession session;
	public TestDAO(HttpServletRequest request) {
		session = request.getSession();
	}
}
