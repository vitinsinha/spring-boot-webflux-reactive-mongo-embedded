package com.spring.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsRepository;

import static org.springframework.security.core.userdetails.User.withUsername;

@Configuration
public class SecurityConfiguration {

    @Bean
    UserDetailsRepository userDetailsRepository() {
        UserDetails tom = withUsername("user").password("password").roles("USER").build();
        UserDetails harry = withUsername("admin").password("password").roles("USER", "ADMIN").build();
        return new MapUserDetailsRepository(tom, harry);
    }
}
