package com.school.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.school.service.UserService;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@EnableWebSecurity //spring Security를 적용한다는 Annotation
@Configuration
@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자를 자동으로 생성해주는 롬복의 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserService userService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and();
    	http.csrf().disable();
    	http
    	.authorizeRequests() //해당 메소드 아래는 각 경로에 따른 권한을 지정할 수 있다. 
    		.antMatchers("/manage/**").authenticated() //manage/** 로 페이지를 요청할때 권한을 체크하도록 한다.
    		.antMatchers("/professor/**").hasAuthority("PROFESSOR") //괄호의 권한을 가진 유저만 가능
    		.antMatchers("/manage/**").access("hasAnyAuthority('USER','PROFESSOR')")
    		.and()
    	.formLogin()//하위에 내가 직접 구현한 로그인 폼, 로그인 성공시 이동 경로 설정 가능. , 로그인 폼의 아이디,패스워드는 username, password로 맞춰야 함
    		.loginPage("/loginPage")//로그인이 수행될 경로
    		.loginProcessingUrl("/login")//로그인form의  action과 일치시켜주어야 함.
    		.defaultSuccessUrl("/manage/main")
    		.failureUrl("/loginPage/?error=true")
    		.and()
    	.logout()//로그아웃설정
    		.permitAll()
    		.logoutUrl("/logout")
    		.logoutSuccessUrl("/")
				.and() 
				.exceptionHandling() 
				.accessDeniedPage("/noAccess");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception{
    	//static 폴더의 하위파일 목록은 인증을 무시하고 항상통과하게 한다.
    	web.ignoring().antMatchers("/css/**","/images/**","/js/**","/vendor/**");
    }
    
    //패스워드 인코딩을 위한 소스코드
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
