package br.edu.univas.si7.topicos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String [] PUBLIC_URLS = {
			"/h2-console/**"
	};
	
	private static final String [] PUBLIC_GET_URLS = {
			"/categories/**",
			"/products/**"
	};
	
	private static final String [] PUBLIC_POST_URLS = {
			"/categories/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(PUBLIC_URLS).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_GET_URLS).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_POST_URLS).permitAll()
			.anyRequest().authenticated();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
