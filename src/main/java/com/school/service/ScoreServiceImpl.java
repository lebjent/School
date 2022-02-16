package com.school.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.ScoreDTO;
import com.school.mapper.ScoreMapper;
import com.school.page.Criteria;

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
	
	
	//성적조회
	@Override
	public List<Map<String, Object>> selectScore(Criteria cri) throws Exception {
		
		return sMapper.selectScore(cri);
	}

	//성적조회 카운트
	@Override
	public int scoreTotal(Criteria cri) throws Exception {
		
		return sMapper.scoreTotal(cri);
	}

	//등수조회
	@Override
	public List<Map<String, Object>> selectRank(Criteria cri) throws Exception {
		
		return sMapper.selectRank(cri);
	}

	
	
	
}
