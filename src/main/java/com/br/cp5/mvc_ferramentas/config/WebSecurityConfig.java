package com.br.cp5.mvc_ferramentas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .failureUrl("/login?error")
                            .permitAll();
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/motoqueiro/dashboard", "/motoqueiro/editar/fechada/**")
                            .hasRole("MOTOQUEIRO");
                    registry.requestMatchers("/moto/**", "/vaga/**", "/patio/**",
                            "/motoqueiro/**", "/secao/**", "/index", "/admin/**").hasAnyRole("ADMIN");

                    registry.requestMatchers("/css/**", "/login").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }
}
