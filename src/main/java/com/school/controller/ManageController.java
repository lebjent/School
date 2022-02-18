package com.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.dto.ScoreDTO;
import com.school.dto.StudentDTO;
import com.school.dto.UserDTO;
import com.school.encode.NumberScore;
import com.school.encode.ScoreEncoding;
import com.school.encode.SpellScore;
import com.school.page.Criteria;
import com.school.page.PageMaker;
import com.school.service.ScoreService;
import com.school.service.StudentService;

import groovyjarjarantlr4.v4.parse.ANTLRParser.sync_return;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manage/*")
public class ManageController {
	
	@Autowired
	private StudentService sService;
	
	@Autowired ScoreService scoreService;
	 
	@GetMapping("/main")
	public String mainPage(Authentication authentication,HttpServletRequest req)throws Exception{
		log.info("메인페이지로 이동");
		//Authentication 객체를 통해 유저 정보를 가져 올 수있다.
		UserDTO uDTO = (UserDTO) authentication.getPrincipal();
		log.info(uDTO.getUserId());
		
		HttpSession session = req.getSession();
		session.setAttribute("info",uDTO.getUserId());
		return "main";
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
	
	//학생리스트 불러오기
	@GetMapping("/studentList")
	public ModelAndView studentList(ModelAndView mv,@ModelAttribute("cri") Criteria cri)throws Exception{
		
		log.info("학생리스트 조회");
		
		//학생리스트 총 카운트 불러오기
		int total = sService.studentTotal(cri);
		//리스트 화면에 총 카운트수 저장하기
		mv.addObject("total",total);
		//PageMaker메서드 호출
		PageMaker pageMake = new PageMaker(cri, total);
		
		//model에 PageMaker 정보저장
		mv.addObject("pageMaker",pageMake);
		
		mv.addObject("list", sService.studentList(cri));
		mv.setViewName("/manage/studentList");
		
		return mv;
	}
	
	//성적조회하기
	@GetMapping("/scoreLookUp")
	public ModelAndView scoreLookUpView(ModelAndView mv,@ModelAttribute("cri") Criteria cri)throws Exception{
		
		log.info("성적조회View");
		
		cri.setAmount(5);
		
		//학생리스트 총 카운트 불러오기
		int total = scoreService.scoreTotal(cri);
		//리스트 화면에 총 카운트수 저장하기
		mv.addObject("total",total);
		//PageMaker메서드 호출
		PageMaker pageMake = new PageMaker(cri, total);
				
		//model에 PageMaker 정보저장
		mv.addObject("pageMaker",pageMake);
		
		
		//기본 점수 입력 및 학생정보 리스트
		List<Map<String,Object>> list = new ArrayList<>();
		list = scoreService.selectScore(cri);
		
		//점수인코딩 메서드 생성자 불러오기
		ScoreEncoding se = new ScoreEncoding();
		
		//알파벳 변환 점수 메서드 불러오기
		List<SpellScore> slist = se.spellScoreEncoding(list);
		
		//넘버 변환점수 메서드 불러오기
		List<NumberScore> nlist = se.numberScoreEncoding(slist);
		
		//원래점수 리스트
		mv.addObject("list",list);
		//영어변환 점수 리스트
		mv.addObject("slist",slist);
		//숫자변환 리스트
		mv.addObject("nlist",nlist);
		mv.setViewName("/manage/scoreLookUp");
		
		return mv;
	}
	
	
	//등수 뷰로 이동
	@GetMapping("/scoreRank")
	public ModelAndView rankView(ModelAndView mv, @ModelAttribute("cri") Criteria cri)throws Exception{
		
		log.info("등수 조회하기");
		//학생리스트 총 카운트 불러오기
		int total = scoreService.scoreTotal(cri);
		
		//리스트 화면에 총 카운트수 저장하기
		mv.addObject("total",total);
		
		//PageMaker메서드 호출
		PageMaker pageMake = new PageMaker(cri, total);
		
		//model에 PageMaker 정보저장
		mv.addObject("pageMaker",pageMake);
		
		mv.addObject("rankList",scoreService.selectRank(cri));
			
		mv.setViewName("/manage/scoreRankView");
		
		return mv;
	}
	
}
