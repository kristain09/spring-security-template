package com.example.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails kris =
                User.withUsername("kris").password("password").authorities("read").build();
        return new InMemoryUserDetailsManager(kris);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        //deprecated but i do not care
        return NoOpPasswordEncoder.getInstance();
    }
}
