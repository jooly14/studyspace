package com.npnc.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.npnc.board.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl service;
	
	@RequestMapping({"/","list"})
	public String list(String type,String keyword,String category,
			@RequestParam(value="page",required=false,defaultValue="1")int page,
			@RequestParam(value="psize",required=false,defaultValue="20")int pagesize, Model model) {
		Map<String, Object> data = service.getList(type, keyword, category, page, pagesize);
		model.addAllAttributes(data);
		data = service.getGradeList();
		model.addAllAttributes(data);
		data = service.getCategoryList();
		model.addAllAttributes(data);
		return "board/list";
	}
	@RequestMapping("/home")
	public void home() {
		service.hello();
	}
}
