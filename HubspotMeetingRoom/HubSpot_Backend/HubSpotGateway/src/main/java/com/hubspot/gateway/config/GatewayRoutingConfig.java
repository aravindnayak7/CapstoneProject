package com.hubspot.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan
@Configuration
public class GatewayRoutingConfig {
	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder)
	{
		
		
		// port for the gateway is 8089
		
//		Static Route
//		return builder.routes()
//				.route("UserId", r -> r.path("/api/v2/**").uri("http://localhost:8081"))
//				.route("NoteId", r -> r.path("/api/v1/**").uri("http://localhost:8080"))
//				.build();	
//		Dynamic Route
		return builder.routes()
				.route("Login", r -> r.path("/auth/user/**").uri("http://localhost:8081"))
				.route("Regsiter", r -> r.path("/api/**").uri("http://localhost:8082"))
				.route("RoomDetails", r -> r.path("/room/**").uri("http://localhost:8084"))
				.route("BookingJpaMs", r -> r.path("/book/**").uri("http://localhost:8083"))
				.route("adminService", r -> r.path("/api/admin**").uri("http://localhost:8085"))
				.build();
	}
}
