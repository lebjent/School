package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.dto.ScoreDTO;
import com.school.dto.StudentDTO;
import com.school.page.Criteria;
import com.school.page.PageMaker;
import com.school.service.ScoreService;
import com.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/professor/*")
public class ProfessorController {
	
	@Autowired
	private StudentService sService;
	@Autowired 
	private ScoreService scoreService;
	
	
	//성적등록하기 뷰
	@GetMapping("/scoreRegView")
	public ModelAndView scoreRegView(ModelAndView mv,@ModelAttribute("cri") Criteria cri)throws Exception{
		
		log.info("성적등록하기 뷰");
		
		//학생리스트 총 카운트 불러오기
		int total = sService.studentTotal(cri);
		//리스트 화면에 총 카운트수 저장하기
		mv.addObject("total",total);
		//PageMaker메서드 호출
		PageMaker pageMake = new PageMaker(cri, total);
		
		//model에 PageMaker 정보저장
		mv.addObject("pageMaker",pageMake);
		
		mv.addObject("list", sService.studentList(cri));
		mv.setViewName("/manage/scoreRegView");
	
		return mv;
	}
	
	//점수등록하기
	@PostMapping("/scoreReg")
	public String scoreRegister(ScoreDTO sDTO,Criteria cri,RedirectAttributes rttr) throws Exception{
		
		log.info("점수등록하기");
		System.out.println(cri.getPageNum());
		
		scoreService.scoreReg(sDTO);
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		rttr.addAttribute("sGrade",cri.getsGrade());
		rttr.addAttribute("sClass",cri.getsClass());
		
		return "redirect:/professor/scoreRegView";
	}
	
	@GetMapping("/studentRegView")
	public ModelAndView studentRegView(ModelAndView mv)throws Exception{
		
		
		log.info("학생 등록 뷰");
		
		mv.setViewName("/manage/studentRegView");
		mv.addObject("studentIdx",sService.autoStudentIdx());
		
		return mv;
	}
	
	//학생등록 소스코드
	@PostMapping("/studentReg")
	public String studentReg(StudentDTO sDTO)throws Exception{
		
		log.debug("학생을 등록합니다.");
		
		sService.studentReg(sDTO);
		
		return "/main";
	}
	
}
