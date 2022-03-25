package com.simple.basic.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.TestController;

// 스프링부트에서는 설정파일을 자바파일로 사용합니다.

@Configuration // 스프링 설정파일임을 의미
@PropertySource("classpath:/application.properties")
public class WebConfig implements WebMvcConfigurer {
	
	// IOC팩토리
	@Autowired
	private ApplicationContext applicationContext;
	
	// application.properties값을 직접참조
	@Value("${spring.datasource.url}")
	private String url; 
	
	@Value("${server.port}")
	private String port;

//	@Bean // 해당 메서드를 빈으로 생성
//	public void test() {
//		System.out.println("테스트 빈 생성!");
//		System.out.println("application 프로퍼티 안의 값: " + url);
//		System.out.println("application 프로퍼티 안의 값: " + port);
//		
//		// IOC컨테이너 안에 객체수
//		int count = applicationContext.getBeanDefinitionCount();
//		System.out.println("IOC컨테이너 안에 객체수: " + count);
//		
//		// 컨트롤러 빈
//		TestController t = applicationContext.getBean(TestController.class);
//		System.out.println("IOC컨테이너 안에 생성된 컨트롤러: " + t);
//		
//		// 내부적으로 만들어진 DB커넥션
//		DataSource ds = applicationContext.getBean(DataSource.class);
//		try {
//			System.out.println(ds.getConnection());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
