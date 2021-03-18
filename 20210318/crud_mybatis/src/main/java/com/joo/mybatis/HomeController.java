package com.joo.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("/")
	public String main(Model model) {
		List<MDto> dtos = dao.getAll();
		model.addAttribute("dtos", dtos);
		return  "main";
	}
	@RequestMapping("/insert")
	public String insert(MDto dto) {
		dao.insert(dto);
		return  "redirect:/";
	}
	
}
