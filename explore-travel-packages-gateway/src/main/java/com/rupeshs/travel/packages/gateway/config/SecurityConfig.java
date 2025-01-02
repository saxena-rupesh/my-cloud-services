package com.rupeshs.travel.packages.gateway.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class    SecurityConfig {
   @Bean
   public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
       return http
               .authorizeExchange(exchanges -> exchanges
                       .pathMatchers(HttpMethod.POST, "/**").authenticated()
                       .pathMatchers(HttpMethod.PUT, "/**").authenticated()
                       .pathMatchers(HttpMethod.PATCH, "/**").authenticated()
                       .pathMatchers(HttpMethod.DELETE, "/**").authenticated()
                      .pathMatchers(HttpMethod.GET, "/**").permitAll()
               )
              .httpBasic(withDefaults())
               .formLogin(withDefaults())
               .csrf(csrf -> csrf.disable()).build();

   }
}
