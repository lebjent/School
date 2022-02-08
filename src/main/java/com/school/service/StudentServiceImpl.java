package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper sMapper;
	
	@Override
	public int autoStudentIdx() throws Exception {
		
		return sMapper.autoStudentIdx();
	}
	
	
	
}
