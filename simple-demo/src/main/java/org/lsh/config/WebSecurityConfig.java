package org.lsh.config;

import org.lsh.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/user/add").permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults()) // 允许跨域
                .formLogin(item -> item
                        .successHandler(new MyAuthenticationSuccessHandler())
                        .failureHandler(new MyAuthenticationFailureHandler()))
                .logout(item -> item.logoutSuccessHandler(new MyLogoutSuccessHandler()))
                .sessionManagement(item -> item
                        .maximumSessions(1) // 最大几个客户端进行登录
                        .expiredSessionStrategy(new MySessionInformationExpiredStrategy()));
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(new MyAuthenticationEntryPoint()));

        return http.build();
    }

}
