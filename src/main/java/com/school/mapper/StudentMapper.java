package com.school.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

@Mapper
public interface StudentMapper {
	
	//학번 자동 불러오는 코드
	public int autoStudentIdx() throws Exception;
	
}
