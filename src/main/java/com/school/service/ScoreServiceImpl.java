package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.ScoreDTO;
import com.school.mapper.ScoreMapper;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreMapper sMapper;
	
	//성적 등록하기
	@Override
	public void scoreReg(ScoreDTO sDTO) throws Exception {
		
		//점수등록여부 업데이트
		sMapper.scoreCheck(sDTO.getStudentIdx());
		
		//점수등록 실행
		sMapper.scoreReg(sDTO);
		
	}
	
	
	
}
