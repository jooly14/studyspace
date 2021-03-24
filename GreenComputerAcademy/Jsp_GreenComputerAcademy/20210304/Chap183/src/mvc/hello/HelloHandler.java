package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class HelloHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("hello", "안녕하세요!");
		// request.setAttribute를 통해서 값넣기 
		// => MDao dao = new MDao()
		// dao.insert() / dao.select()
		
		// return에 이동할 페이지 작성
		return "/WEB-INF/view/hello.jsp";
	}

}




