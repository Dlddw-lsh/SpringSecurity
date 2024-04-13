package org.lsh.config;

import org.lsh.handler.MyAuthenticationEntryPoint;
import org.lsh.handler.MyAuthenticationFailureHandler;
import org.lsh.handler.MyAuthenticationSuccessHandler;
import org.lsh.handler.MyLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
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
                .logout(item -> item.logoutSuccessHandler(new MyLogoutSuccessHandler()));
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(new MyAuthenticationEntryPoint()));

        return http.build();
    }

}
