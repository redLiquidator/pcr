package com.pcr.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
DataSource dataSource;
 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // it will check or tell us , what are the users, their passwords, and roles
	    //first login : id| user , pw| generated security password(in cosole)
	    //set id & pw in application.properties
	    //AuthenticationManagerBuilder not resolved error -> security dependency3,4 added -> fixed
	    //java.lang.NoClassDefFoundError: org/springframework/security/converter/RsaKeyConverters -> security dependency3 version deleted -> fixed
        auth.inMemoryAuthentication()
                .withUser("manish")
                .password("123")
                .roles("USER")
                .and()
                .withUser("Jinjoo")
                .password("1234")
                .roles("ADMIN");

        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }
 
 @Bean
 	public PasswordEncoder getPasswordEncoder(){
     return NoOpPasswordEncoder.getInstance();
 }
 
 protected void configure(HttpSecurity http) throws Exception {
	//it will configure the mappings, what kind of mapping are allowed for what users
	//upper lines have priority 
	 http.authorizeRequests()
	 			.antMatchers("/admin").hasRole("ADMIN")
	 			.antMatchers("/user").hasAnyRole("USER")
	 			.antMatchers("/front").hasAnyRole("ADMIN","USER")
	 			//.antMatchers("/**").permitAll()	
	 			.and().formLogin();
 }
 }