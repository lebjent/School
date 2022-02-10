package com.school.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.school.dto.StudentDTO;
import com.school.page.Criteria;

@Mapper
public interface StudentMapper {
	
	//학번 자동 불러오는 코드
	public int autoStudentIdx() throws Exception;
	
	//학생등록 코드
	public void studentReg(StudentDTO sDTO) throws Exception;
	
	//학생리스트
	public List<StudentDTO>studentList(Criteria cri)throws Exception;
	
	//학생총 카운트
	public int studentTotal(Criteria cri)throws Exception;

}
