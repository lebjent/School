package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.UserDTO;
import com.school.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService  {
	
	@Autowired
	private UserMapper userMapper;
	
	
	//회원가입
	@Transactional
	public void saveUser(UserDTO uDTO) throws Exception{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		uDTO.setUserPw(passwordEncoder.encode(uDTO.getPassword()));
		userMapper.saveUser(uDTO);
	}
	
	//유저패스워드와 비교하여 로그인을 인증해준다.
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserDTO uDTO = userMapper.getUserAccount(userId);
		//아이디가 없는 경우
		if(uDTO == null) {
			throw new UsernameNotFoundException("User not authorized.");
		}
		return uDTO;
	}
	
	
	//아이디 중복확인
	public int idChk(String userId)throws Exception{
		
		return userMapper.idChk(userId);
	}
	
	//학생테이블에서 학번이 있는지 체크
	public int studentIdxChk(int studentIdx) throws Exception{
		
		return userMapper.studentIdxChk(studentIdx);
	}
	
	//회원테이블에서 학번이 있는지 더블체크
	public int studentIdxDoubleChk(int studentIdx) throws Exception{
		
		return userMapper.studentIdxDoubleChk(studentIdx);
	}
	

}
