package com.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.challenge.security.JWTAuthorizationFilter;
import com.challenge.security.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
    	
    	JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
    	jwtAuthenticationFilter.setAuthenticationManager(authManager);
    	jwtAuthenticationFilter.setFilterProcessesUrl("/login");

		http
				.csrf().disable() // Deshabilitar CSRF para permitir peticiones POST
				.authorizeRequests(authorizeRequests ->
						authorizeRequests
								.antMatchers("/swagger-ui.html").permitAll() // Permitir acceso a swagger-ui.html sin autenticación
								.antMatchers(HttpMethod.GET, "/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/webjars/**", "/swagger/**").permitAll() // Permitir acceso a los endpoints de Swagger sin autenticación
								.antMatchers("/api/**").authenticated() // Requerir autenticación para cualquier otro endpoint bajo /api/
				)
				.sessionManagement(sessionManagement ->
						sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configurar políticas de sesión sin estado
				)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
    }
    
    @Bean
    AuthenticationManager authManager (HttpSecurity http) throws Exception {
    	return http.getSharedObject(AuthenticationManagerBuilder.class)
    			.userDetailsService(userDetailsService)
    			.passwordEncoder(passwordEncoder())
    			.and()
    			.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
