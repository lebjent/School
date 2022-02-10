package com.school.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.school.dto.ScoreDTO;

@Mapper
public interface ScoreMapper {
	
	//점수등록
	public void scoreReg(ScoreDTO sDTO) throws Exception;
	
	//점수등록시 학생테이블 점수등록여부 업데이트
	public void scoreCheck(int studentIdx) throws Exception;
}
