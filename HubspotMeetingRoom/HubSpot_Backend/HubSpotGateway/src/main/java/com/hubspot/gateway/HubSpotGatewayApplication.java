package com.hubspot.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hubspot.gateway.JWTFilter.jwtFilterGateway;

@SpringBootApplication
@EnableFeignClients

public class HubSpotGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HubSpotGatewayApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() 
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new jwtFilterGateway());
		filterRegistrationBean.addUrlPatterns("h/**");
		return filterRegistrationBean;
	}
}
