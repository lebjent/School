package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentDTO;
import com.school.mapper.StudentMapper;
import com.school.page.Criteria;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper sMapper;
	
	//학생정보 불러오는 코드
	@Override
	public int autoStudentIdx() throws Exception {
		
		return sMapper.autoStudentIdx();
	}
	
	//학생등록 소스코드
	@Override
	public void studentReg(StudentDTO sDTO) throws Exception {
		
		sMapper.studentReg(sDTO);
		
	}
	
	//학생리스트 불러오기
	@Override
	public List<StudentDTO> studentList(Criteria cri) throws Exception {
		
		return sMapper.studentList(cri);
	}
	
	//학생 총 카운트
	@Override
	public int studentTotal(Criteria cri) throws Exception {
		
		return sMapper.studentTotal(cri);
	}
	
	
	
	
}
