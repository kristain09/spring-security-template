package com.example.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails kris =
                User.withUsername("kris").password("password").authorities("read").build();
        return new InMemoryUserDetailsManager(kris);
    }


    //Customizer is an interface(contract) to define customization for either
    // Spring security element to configure
    // it is functional interface, so WE CAN USE LAMBDA EXPRESSION TO
    // IMPLEMENT IT and with defaults is does nothing bro!
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //whole app
        http.httpBasic(Customizer.withDefaults());
        // endpoint level
        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //deprecated but i do not care
        return NoOpPasswordEncoder.getInstance();
    }
}
