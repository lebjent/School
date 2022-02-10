package com.school.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("StudentDTO")
@Data
public class StudentDTO {
	
	private int studentIdx;
	private String studentName;
	private String studentPhone;
	private String studentGrade;
	private String studentClass;
	private String scoreYn;
	
}
