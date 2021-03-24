package com.joo.g22controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joo.dao.BDao;
import com.joo.dao.MDao;
import com.joo.dto.BDto;
import com.joo.dto.MDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BDao dao;
	@Autowired
	private MDao mdao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping({"/","/main"})
	public String main(@RequestParam(value="page", required=false, defaultValue="1")int page,
			@RequestParam(value="pagesize", required=false, defaultValue="5")int pagesize
			,Model model) {
		model.addAttribute("dtos",dao.getAll(page,pagesize));
		
		int cnt = dao.getCnt();
		model.addAttribute("cnt",cnt);
		int start = (page/pagesize)*pagesize+1;
		if(page%pagesize==0) {
			start = (page/pagesize-1)*pagesize+1;
		}
		int totalpage = cnt/pagesize;
		if(cnt%pagesize!=0) {
			totalpage++;
		}
		int end = start+4;
		if(end>totalpage) {
			end = totalpage;
		}
		model.addAttribute("cnt",cnt);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("page", page);
		return "main";
	}
	@RequestMapping({"/insert"})
	public void insert() {
	}
	@RequestMapping({"/doInsert"})
	public String doInsert(BDto dto) {
		dao.insert(dto);
		return "redirect:/main";
	}
	@RequestMapping({"/read"})
	public String read(int idx,Model model,HttpServletRequest request,HttpServletResponse response) {
		boolean idUpdated = false;
		for(Cookie c:request.getCookies()) {
			if(c.getValue().equals(idx+"")) {
				idUpdated = true;
				break;
			}
		}
		if(!idUpdated) {
			Cookie cookie = new Cookie("hit"+idx,idx+"");
			cookie.setMaxAge(1*24*60*60);
			dao.updateHit(idx);
			response.addCookie(cookie);
		}
		model.addAttribute("dto",dao.getData(idx));
		return "read";
	}
	@RequestMapping({"/update"})
	public String read(int idx,Model model) {
		model.addAttribute("dto",dao.getData(idx));
		return "update";
	}
	@RequestMapping({"/doUpdate"})
	public String doUpdate(BDto dto) {
		dao.update(dto);
		return "redirect:/main";
	}
	@RequestMapping({"/delete"})
	public String delete(int idx) {
		dao.delete(idx);
		return "redirect:/main";
	}
	@RequestMapping({"/login"})
	public String login(MDto dto ,HttpSession session) {
		if(mdao.login(dto)==1) {
			session.setAttribute("ldata", dto);
		}
		return "redirect:/main";
	}
	@RequestMapping({"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	@RequestMapping({"/signup"})
	public void signup() {
	}
	@RequestMapping({"/doSignup"})
	public String doSignup(MDto dto) {
		mdao.signup(dto);
		return "redirect:/main";
	}
	@RequestMapping({"/deleteId"})
	public String deleteId(String pw,HttpSession session) {
		int result = mdao.deleteId(((MDto)session.getAttribute("ldata")).getId(),pw);
		if(result==1) {
			session.invalidate();
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/idchk")
	@ResponseBody
	public Map<String, String> idchk(String id) {
		HashMap<String, String> map = new HashMap<>();
		if(mdao.idchk(id)==1) {
			map.put("exist", "t");
		}else {
			map.put("exist", "f");
		}
		return map;
	}
	
}
