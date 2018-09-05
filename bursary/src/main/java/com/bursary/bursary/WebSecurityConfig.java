package com.bursary.bursary;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.inMemoryAuthentication()
	      .withUser("admin").password("admin123").roles("USER");
	   }

	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests().antMatchers("/").hasRole("USER")
	      .and()
	      .httpBasic();
	   }
}
