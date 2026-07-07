package com.cognizant.jwt_handson.filter;


import com.cognizant.jwt_handson.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;



@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {



        String header = request.getHeader("Authorization");


        System.out.println("HEADER = " + header);



        String username = null;

        String token = null;



        if(header != null && header.startsWith("Bearer ")) {


            token = header.substring(7);


            try {

                username = jwtUtil.extractUsername(token);

                System.out.println("USERNAME = " + username);

            }
            catch(Exception e){

                System.out.println("JWT ERROR = " + e.getMessage());

            }

        }



        if(username != null) {


            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(username);



            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );



            authentication.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );



            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);



            System.out.println("AUTHENTICATED = " + username);

        }



        filterChain.doFilter(request,response);

    }

}