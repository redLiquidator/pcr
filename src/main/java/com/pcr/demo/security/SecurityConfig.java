package com.pcr.demo.security;

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
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
DataSource dataSource;
// localhost:8080/logout   | logout
// localhost:8080/login    | login 
@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // it will check or tell us , what are the users, their passwords, and roles
	    //first login : id| user , pw| generated security password(in cosole)
	    //set id & pw in application.properties
	    //AuthenticationManagerBuilder not resolved error -> security dependency3,4 added -> fixed
	    //java.lang.NoClassDefFoundError: org/springframework/security/converter/RsaKeyConverters -> security dependency3 version deleted -> fixed
        //authentication register using config file
	 	auth.inMemoryAuthentication()
                .withUser("manish")
                .password("123")
                .roles("USER")
                .and()
                .withUser("benjamin")
                .password("1234")
                .roles("ADMIN");
	 	//authentication register using database
        auth.jdbcAuthentication()
                 .dataSource(dataSource);
    }
 //password hashing
	
	  @Bean 
	  public PasswordEncoder getPasswordEncoder(){ 
		  return NoOpPasswordEncoder.getInstance(); 
	  }
	 
 
 protected void configure(HttpSecurity http) throws Exception {
	//it will configure the mappings, what kind of mapping are allowed for what users
	//upper lines have priority 
	//authorization 
	//when access denied, browser show 403 
	 http.csrf().disable()    //disable it if the application users did not use it from browsers.
	 			.authorizeRequests()
	 			//.antMatchers("/**").hasAnyRole()  //all the people can access all pages
	 			.antMatchers("/","static/css","static/js").permitAll()   //allow anybody access to these css&js files irrespective of spring security
	 			//.antMatchers("/**").hasRole("ADMIN")  //people who has user role can access all pages
				.antMatchers("/admin").hasRole("ADMIN")
	 			.antMatchers("/user").hasAnyRole("USER","ADMIN")
	 			.antMatchers("/front").hasAnyRole("ADMIN","USER")
	 			//.antMatchers("/**").permitAll()	
	 			 .and().formLogin();
	 
	 http.headers().frameOptions().disable();  //enable h2 console access
 }
 }