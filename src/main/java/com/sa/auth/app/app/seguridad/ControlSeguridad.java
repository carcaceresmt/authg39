/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.auth.app.app.seguridad;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


/**
 *
 * @author DELL
 */
public class ControlSeguridad extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception{
         
         http.authorizeRequests(a -> a.antMatchers("/error",
                "/webjars/**", "/Reservation/**", "/client/**", "/Gama/**",
                "/Car/**", "/cliente/**", "/Score/**", "/Message/**,/api/mensaje/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))                             
        ).oauth2Login().and().logout(l -> l
            .logoutSuccessUrl("/").permitAll())
       ;  
        http.cors().and().csrf().disable();
       // ... existing code here
       
       
    }
        
    }
    
    

