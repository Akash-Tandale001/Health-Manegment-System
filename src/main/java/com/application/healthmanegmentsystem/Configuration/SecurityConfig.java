package com.application.healthmanegmentsystem.Configuration;

import com.application.healthmanegmentsystem.Data.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    private static final String[] PUBLIC_ENDPOINT = {
            "/",
            "/login",
            "/registration",
            "/process-registration",
            "/about",
            "/bookAppointment",
            "/services/**",
            "/doctor",
            "/profile",
            "/admin/**"
    };

    @Bean
    public DaoAuthenticationProvider daoAuthentication(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers( "/js/**",
                "/css/**",
                "/image/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC_ENDPOINT).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/process-login")
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .csrf()
                .and()
                .authenticationProvider(daoAuthentication());
        return http.build();
    }

}
