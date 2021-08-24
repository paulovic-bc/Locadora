
 package com.locadora.Locadora.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.locadora.Locadora.service.AutentificacaoService;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	AutentificacaoService autentificacaoService;
	//config autentificacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(autentificacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	//config Autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/api/filmes").permitAll()
		.antMatchers(HttpMethod.GET,"/api/filmeId/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
		
		
	
			
	}
	//config recursos  estaticos(js,css,imgs)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}

}
