package com.s3filemanager.s3_file_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails admin =
        User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin@123")
            .roles("ADMIN")
            .build();

    UserDetails user =
        User.withDefaultPasswordEncoder()
            .username("user")
            .password("user@123")
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(admin, user);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, "/files/upload")
        .hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/files/delete")
        .hasRole("ADMIN")
        .requestMatchers(HttpMethod.GET, "/files/*")
        .hasAnyRole("ADMIN", "USER")
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
    return http.build();
  }
}
