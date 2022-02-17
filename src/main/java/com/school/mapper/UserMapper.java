package com.school.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.school.dto.UserDTO;
@Mapper
public interface UserMapper {
	
	//로그인
	public UserDTO getUserAccount(String userId);
	
	//회원가입
	public void saveUser(UserDTO uDTO);
	
	//아이디 중복확인
	public int idChk(String userId) throws Exception;
	
	//학생테이블에서 학번이 있는지 체크
	public int studentIdxChk(int studentIdx) throws Exception;
	
	//회원테이블에서 학번이 있는지 더블체크
	public int studentIdxDoubleChk(int studentIdx) throws Exception;
}
