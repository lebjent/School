package com.school.service;

import java.util.List;

import com.school.dto.StudentDTO;
import com.school.page.Criteria;

public interface StudentService {
	
	//학번 자동 불러오는 코드
	public int autoStudentIdx() throws Exception;
	
	//학생등록 코드
	public void studentReg(StudentDTO sDTO) throws Exception;
	
	//학생리스트
	public List<StudentDTO>studentList(Criteria cri)throws Exception;
	
	//학생총 카운트
	public int studentTotal(Criteria cri)throws Exception;
	
}
