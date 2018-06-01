package com.goalkeeper.hcb.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException ex)
			throws IOException, ServletException {
		System.out.println("===== commence error code for unauth user");
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized User");
		
	}

}
