package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.MDao;
import mvc.dto.MDto;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		String viewpage = "";
		MDao dao = new MDao();
		Object obj = null;
		if(cmd ==null){
			cmd = "main";
		}
		if(cmd.equals("main")){
			String curpage = request.getParameter("page");
			if(curpage==null){
				curpage="1";
			}
			int pagesize = 5;
			viewpage = "/main.jsp";
			obj = dao.selectAll(curpage,pagesize);
			int totalpage = dao.getTotalcnt()/pagesize;
			if(dao.getTotalcnt()%pagesize!=0){
				totalpage++;
			}
			request.setAttribute("page", curpage);
			request.setAttribute("result", obj);
			request.setAttribute("totalcnt", dao.getTotalcnt());
			request.setAttribute("totalpage", totalpage);
		}else if(cmd.equals("del")){
			int result = dao.delete(request.getParameter("idx"));
			if(result>0){
				response.sendRedirect(request.getContextPath());
			}else{
				viewpage = "/complete.jsp";
				request.setAttribute("result", "삭제 실패");
			}
		}else if(cmd.equals("signup")){
			viewpage = "/signupform.jsp";
		}else if(cmd.equals("signupproc")){
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			MDto dto = new MDto(id, pw, name);
			int result = dao.idChk(id);
			if(result>0){
				viewpage="/signupform.jsp";
				dto.setId("사용할 수 없는 아이디");
				request.setAttribute("result", dto);
			}else{
				result = dao.insert(dto);
				if(result>0){
					response.sendRedirect(request.getContextPath());
				}else{
					viewpage = "/complete.jsp";
					request.setAttribute("result", "회원가입 실패");
				}
			}
		}else if(cmd.equals("signinform")){
			viewpage = "/signinform.jsp";
		}else if(cmd.equals("signin")){
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			MDto dto = new MDto(id, pw, null);
				int result = dao.signin(dto);
				if(result>0){
					request.getSession(true).setAttribute("authid", id);
					response.sendRedirect(request.getContextPath());
				}else{
					viewpage = "/signinform.jsp";
					request.setAttribute("result", "아이디 혹은 비밀번호가 일치하지 않습니다");
				}
		}else if(cmd.equals("signout")){
			request.getSession(false).invalidate();
			response.sendRedirect(request.getContextPath());
		}else if(cmd.equals("moduserform")){
			MDto dto = dao.selectOne((String)request.getSession(false).getAttribute("authid"));
			request.setAttribute("result", dto);
			viewpage = "/moduserform.jsp";
		}else if(cmd.equals("moduser")){
			int idx = Integer.parseInt(request.getParameter("idx"));
			String pw = request.getParameter("pw");
			String oldpw = request.getParameter("oldpw");
			String name = request.getParameter("name");
			String id = (String)request.getSession(false).getAttribute("authid");
			MDto dto = new MDto(idx, id, pw, name);
			int result = dao.moduser(dto, oldpw);
			if(result>0){
				request.setAttribute("result", "수정 완료");
			}else{
				request.setAttribute("result", "회원정보수정 실패");
			}
			viewpage = "/complete.jsp";
		}
		if(!viewpage.equals("")){
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
		}
	}
}
