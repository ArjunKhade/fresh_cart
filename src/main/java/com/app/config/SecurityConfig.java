//package com.app.config;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.app.filters.JWTRequestFilter;
//@Configuration
//@EnableWebSecurity
//@EnableWebMvc
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//	
//	@Autowired
//	private JWTRequestFilter filter;
//	
//	
//	public static final String[] PUBLIC_URLS = {
//			"/api/v1/auth/**",
//			"/v3/api-docs",
//			"/v2/api-docs",
//			"/swagger-resources/**",
//			"/swagger-ui/**",
//			"/webjars/**"
//	};
//	
//	/********************************************************************/
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.cors().and().csrf().disable().//enable cors, disable csrf attack
//		exceptionHandling().//unable exception handling
//		authenticationEntryPoint((request,response,ex) -> {
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());
//		}).
//		and().
//		authorizeRequests().
//		antMatchers("/users/signup","/store/**","/auth/signup","/auth/signin","/products","/category","/users","/auth/**","/products/category/{categoryId}/seller/{sellerId}").permitAll().
//		
//		antMatchers(PUBLIC_URLS).permitAll().antMatchers(HttpMethod.GET).permitAll().
//		
//		
//		
//		//req for js client
//		antMatchers(HttpMethod.OPTIONS).permitAll().
//		anyRequest().authenticated().
//		and().
//		sessionManagement().
//		sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//		and().
//		addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
//	}
//	
//	
//	/********************************************************************/
//	// configure auth mgr bean : to be used in Authentication REST controller
//	@Bean
//	public AuthenticationManager authentictionMgr(AuthenticationConfiguration config)throws Exception{
//		return config.getAuthenticationManager();
//	}
//	
//	/********************************************************************/
//	
//	
//	
//}
