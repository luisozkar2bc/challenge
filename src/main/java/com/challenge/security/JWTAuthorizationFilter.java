package com.challenge.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null) {
			String token ="";
			if(bearerToken.startsWith("Bearer ")) {
				token = bearerToken.replace("Bearer ", "");
			}else{
				token = bearerToken;
			}
			UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(usernamePAT);
		}
			
		filterChain.doFilter(request, response);
	}

}
