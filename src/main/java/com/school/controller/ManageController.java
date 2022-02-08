package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.service.StudentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/manage/*")
public class ManageController {
	
	@Autowired
	private StudentService sService;
	
	@GetMapping("/studentRegView")
	public ModelAndView studentRegView(ModelAndView mv)throws Exception{
		
		
		log.info("학생 등록 뷰");
		
		mv.setViewName("/manage/studentRegView");
		mv.addObject("studentIdx",sService.autoStudentIdx());
		
		return mv;
	}
	
	
	
}
