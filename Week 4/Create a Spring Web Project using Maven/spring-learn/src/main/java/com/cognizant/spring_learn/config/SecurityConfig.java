package com.cognizant.spring_learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring Security Filter Chain");

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())
            
            // Configure session management to be stateless
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // Configure authorization
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/authenticate").permitAll()  // Allow authentication endpoint
                .requestMatchers("/hello", "/country", "/country/**", "/countries/**").permitAll()  // Allow existing endpoints
                .anyRequest().authenticated()  // All other requests require authentication
            )
            
            // Disable form login since we're using JWT
            .formLogin(form -> form.disable())
            
            // Disable HTTP Basic since we're handling it manually in the controller
            .httpBasic(basic -> basic.disable());

        LOGGER.info("Security configuration completed");
        return http.build();
    }
}
