package com.school.service;

import java.util.List;
import java.util.Map;

import com.school.dto.ScoreDTO;
import com.school.page.Criteria;

public interface ScoreService {
	
	//점수등록
	public void scoreReg(ScoreDTO sDTO) throws Exception;
	
	//성적조회
	public List<Map<String,Object>>selectScore(Criteria cri)throws Exception;
	
	//성적조회 총 카운트
	public int scoreTotal(Criteria cri)throws Exception;
	
}
