package com.reg.api.JWTFilter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
//import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class jwtFilterAuthLogin extends GenericFilterBean{

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException

    {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        

        String authHeader = httpRequest.getHeader("Authorization");

        

        System.out.println("AuthHeader: " +  authHeader);

        

        if(authHeader == null || !authHeader.startsWith("Bearer "))

        {

            throw new ServletException("Missing or Invalid Authentication Header");

        }

        

        String jwtToken = authHeader.substring(7);

        

        Claims claims = Jwts.parser().setSigningKey("secret key").parseClaimsJws(jwtToken).getBody();

        httpRequest.setAttribute("email", claims);

        chain.doFilter(request, response);

    }

}
