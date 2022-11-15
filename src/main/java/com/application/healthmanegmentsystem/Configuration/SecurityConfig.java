package com.application.healthmanegmentsystem.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/js/**", "/css/**").permitAll()
                .antMatchers("/login","/home").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/process-login")
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .csrf();
        return http.build();
    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
