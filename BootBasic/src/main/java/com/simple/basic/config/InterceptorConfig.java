package com.simple.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.interceptor.UserAuthHandler;

@Configuration // 스프링 설정파일임을 의미
public class InterceptorConfig implements WebMvcConfigurer {
	
	// 1. 
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(userAuthHandler())
//		.addPathPatterns("/user/mypage")
		.addPathPatterns("/user/*")
		.excludePathPatterns("/user/login");
		
	}
	
	
	
}
