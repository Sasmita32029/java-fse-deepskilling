package com.cognizant.jwt_handson.config;


import com.cognizant.jwt_handson.filter.JwtAuthorizationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {


        UserDetails user = User.builder()
                .username("user")
                .password("pwd")
                .roles("USER")
                .build();



        UserDetails admin = User.builder()
                .username("admin")
                .password("pwd")
                .roles("ADMIN")
                .build();



        return new InMemoryUserDetailsManager(user, admin);

    }



    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();

    }



    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {

        return configuration.getAuthenticationManager();

    }



  @Bean
public SecurityFilterChain securityFilterChain(
        HttpSecurity http,
        JwtAuthorizationFilter jwtAuthorizationFilter
) throws Exception {


    http
        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth

                .requestMatchers("/authenticate")
                .permitAll()

                .requestMatchers("/countries")
                .authenticated()

                .anyRequest()
                .authenticated()
        )

        .sessionManagement(session ->
                session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                )
        )

        .addFilterBefore(
                jwtAuthorizationFilter,
                UsernamePasswordAuthenticationFilter.class
        );


    return http.build();
}

}