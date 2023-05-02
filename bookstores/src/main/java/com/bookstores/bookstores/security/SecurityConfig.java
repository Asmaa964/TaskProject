package com.bookstores.bookstores.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.bookstores.bookstores.Services.UserDetailsServiceImp;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImp);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/h2-console/**").permitAll() // allow access to H2 console
		.antMatchers("/books").permitAll()
		.antMatchers("/stores").hasAnyRole("normalUser", "storeAdmin")
		.antMatchers("/stores/*").hasAnyRole("normalUser", "storeAdmin")
		.antMatchers("/stores/*/books")
		.hasAnyRole("storeAdmin").anyRequest().authenticated()
		.and().httpBasic()
		.and().csrf().disable()
		.headers().frameOptions().disable().and()
		 .exceptionHandling().accessDeniedHandler(accessDeniedHandler());;

	}
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new CustomAccessDeniedHandler();
	}

}
