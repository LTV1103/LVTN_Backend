package com.learning.lvtn_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // tắt CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // cho phép mọi request
                )
                .httpBasic(basic -> basic.disable()) // tắt Basic Auth
                .formLogin(form -> form.disable());

        return http.build();
    }
}
