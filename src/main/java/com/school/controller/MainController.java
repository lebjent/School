package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() throws Exception{
		
		log.info("인덱스 페이지");
		
		return "index";
	}
	
	@GetMapping("/main")
	public String layouttest()throws Exception{
		log.info("메인페이지로 이동");
		
	return "main";
	}
	
	@GetMapping("/loginPage")
	public String login()throws Exception{
		
		return "login";
	}
}
