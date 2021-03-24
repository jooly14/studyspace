package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class HelloHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("hello", "�ȳ��ϼ���!");
		// request.setAttribute�� ���ؼ� ���ֱ� 
		// => MDao dao = new MDao()
		// dao.insert() / dao.select()
		
		// return�� �̵��� ������ �ۼ�
		return "/WEB-INF/view/hello.jsp";
	}

}




