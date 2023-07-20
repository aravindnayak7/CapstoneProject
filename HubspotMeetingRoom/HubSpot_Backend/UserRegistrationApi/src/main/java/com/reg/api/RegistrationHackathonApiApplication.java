package com.reg.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.reg.api.JWTFilter.jwtFilterAuthLogin;

@SpringBootApplication
@EnableDiscoveryClient
public class RegistrationHackathonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationHackathonApiApplication.class, args);
	}
	
//	@Bean
//	public FilterRegistrationBean jwtFilter() 
//	{
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new jwtFilterAuthLogin());
//		filterRegistrationBean.addUrlPatterns("/api/v3/**");
//		return filterRegistrationBean;
//	}
}
