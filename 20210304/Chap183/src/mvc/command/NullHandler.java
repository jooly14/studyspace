package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		res.sendError(HttpServletResponse.SC_NOT_FOUND);
		// 실제로는 그냥 jsp 하나 만들어서 null 입니다 이런 내용만들고
		// 그냥 그쪽으로 페이지 이동시키면 됩니다.
		
		return null;
	}

}
