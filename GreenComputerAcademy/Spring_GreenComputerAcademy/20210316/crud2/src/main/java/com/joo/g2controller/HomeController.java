package com.joo.g2controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CDao dao;
	@Autowired
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/main","/list"})
	public String main(@RequestParam(value="page", required=false, defaultValue="1")int page,@RequestParam(value="pagesize", required=false, defaultValue="5")int pagesize,Model model) {
		int cnt = dao.getCnt();
		model.addAttribute("cnt",cnt);
		String content = "이것이 출력된다면 컨트롤러를 거친거다";
		List<CDto> dtos = dao.getAll(page,pagesize);
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
		model.addAttribute("list",dtos);
		model.addAttribute("result",content);
		model.addAttribute("cnt",cnt);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("page", page);
		model.addAttribute("path",uploadPath);
		return "list";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	@RequestMapping(value = "/doInsert")
	public RedirectView doInsert(String id, String pw, String content,MultipartFile file,HttpServletRequest request) {
		CDto dto = null;
		if(file!=null&&!file.isEmpty()) {
			File fileupload = new File(request.getSession ().getServletContext().getRealPath("/"+uploadPath+file.getOriginalFilename()));
			File filepath = new File(request.getSession ().getServletContext().getRealPath("/"+uploadPath));
			if(!filepath.exists()) {
				filepath.mkdirs();
			}
			int idx = 0;
			while(fileupload.exists()) {
				idx++;
				int splitidx = 0;
				int dotidx = 0;
				dotidx = file.getOriginalFilename().lastIndexOf(".");
				fileupload = new File(request.getSession ().getServletContext().getRealPath("/"+uploadPath+file.getOriginalFilename().substring(0,dotidx))+"("+idx+")"+file.getOriginalFilename().substring(dotidx));
			}
			try {
				FileCopyUtils.copy(file.getBytes(), fileupload);
			} catch(Exception e) {
				e.printStackTrace();
			}
			dto = new CDto(id, pw, content, fileupload.getName(),file.getOriginalFilename());
		}else {
			dto = new CDto(id, pw, content, null, null);
		}
		dao.insert(dto);
		RedirectView rv = new RedirectView("list");
		rv.setExposeModelAttributes(false);
		return rv;
	}
	@RequestMapping("/delete")
	public String delete(int num) {
		dao.delete(num);
		return "redirect:main";
	}
	@RequestMapping("/update")
	public String update(int num,Model model) {
		CDto dto = dao.getData(num);
		model.addAttribute("dto",dto);
		model.addAttribute("path",uploadPath);
		return "update";
	}
	@RequestMapping("/doUpdate")
	public String doUpdate(int num, String content,Model model) {
		dao.update(content, num);
		return "redirect:main";
	}
}
