package com.school.dto;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Alias("UserDTO")
@Data
public class UserDTO implements UserDetails {
	
	//스프링 시큐리티의 인증정보를 담기 위해서는 스프링 시큐리티에서 제공하는 UserDetails의 인터페이스를 상속받고
	//기본VO를 반드시 정의 해야지 빨간줄이 사라진다.
	
	private int studentIdx;
	private String userId;
	private String userPw;
	private String userName;
	private String userAuth;
	private Date userJoin;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singletonList(new SimpleGrantedAuthority(this.userAuth));
	}

	@Override
	public String getPassword() {
		
		return this.userPw;
	}

	@Override
	public String getUsername() {
		
		return this.userId;
	}
	
	//조금더 공부해야겠지만 우선은 전부 true로 설정한다.	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
