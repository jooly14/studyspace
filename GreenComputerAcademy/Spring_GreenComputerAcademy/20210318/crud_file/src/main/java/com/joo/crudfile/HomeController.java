package com.joo.crudfile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private String uploadpath = "/resources/upload";
	@Autowired
	private FDao fdao;
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = {"/","/main"})
	public String main(Model model) {
		model.addAttribute("dtos",fdao.getAll());
		
		return "main";
	}
	
	@RequestMapping(value = {"upload"})
	public String upload(String name, MultipartFile file,RedirectAttributes reAttr) {
		String contextpath = context.getRealPath("/");
		File path = new File(contextpath,uploadpath);
		if(!path.exists()) {
			path.mkdirs();
		}
		try {
			file.transferTo(new File(path.getAbsolutePath(),file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FDto dto = new FDto(0, file.getOriginalFilename(), name);
		fdao.insert(dto);
		reAttr.addFlashAttribute("path",uploadpath);
		return "redirect:/";
	}
	
	@RequestMapping(value = {"download"},produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(String filename) {
		String contextpath = context.getRealPath("/");
		Resource resource = new FileSystemResource(contextpath+uploadpath+"/"+filename);
		String name = resource.getFilename();
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("Content-Disposition", "attachment; filename="+new String(name.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(resource, header, HttpStatus.OK);
	}
	
}
