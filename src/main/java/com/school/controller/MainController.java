package com.school.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.dto.UserDTO;
import com.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	//인덱스 페이지로이동
	@GetMapping("/")
	public String index() throws Exception{
		
		log.info("인덱스 페이지");
		
		return "index";
	}
	
	//로그인 페이지로 이동
	@GetMapping("/loginPage")
	public String login()throws Exception{
		return "login";
	}
	
	//회원가입 선택 페이지로 이동
	@GetMapping("/memberJoinView")
	public String memberJoinView()throws Exception{
		
		log.info("회원가입페이지로 이동");
		
		return "memberJoinView";
	}
	
	//학생 가입페이지로이동
	@GetMapping("/studentJoin")
	public String studentJoinView()throws Exception{
		log.info("학생 회원가입");
		
		return "studentJoinView";
	}
	
	//교수 가입페이지로 이동
	@GetMapping("/professorJoin")
	public String professorJoinView()throws Exception{
		log.info("교수 회원가입");
		
		return "professorJoinView";
	}
	
	//아이디 중복체크ajax
	@ResponseBody
	@PostMapping("/idChk")
	public int idChk(@RequestParam("userId")String userId) throws Exception{
		
		int value = userService.idChk(userId);
		
		return value;
	}
	
	//학번 체크 및 학번으로 가입된 아이디가 있는지 체크
	@ResponseBody
	@PostMapping("/studentIdxChk")
	public int studentIdxChk(@RequestParam("studentIdx") int studentIdx) throws Exception{
		
		int value = userService.studentIdxChk(studentIdx);
		//1의 경우 학번이 없다는 메세지 안내
		if(value==0) {
			return 1;
		}else if(value == 1) {
		//2의 경우 학번 더블 체크하고 회원가입이 가능하다는 메시지 전송
			value = userService.studentIdxDoubleChk(studentIdx);
			if(value==0) {
				return 2;
			}else {
				//3의 경우 이미해당 학번으로 가입되 아이디가 있다고 안내
				return 3;
			}
		}
		
		return value;
	}
	
	//회원가입
	@PostMapping("/memberJoin")
	public String memberJoin(UserDTO uDTO) throws Exception{
		
		userService.saveUser(uDTO);
		
		return "redirect:/loginPage";
	}
	
	//교수님만 접근가능시
	@GetMapping("/noAccess")
	public String noAccess()throws Exception{
		
		return "noAccess";
	}
}
