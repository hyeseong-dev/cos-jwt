package com.cos.jwt.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    CorsConfigurationSource corsConfigSource(){

        CorsConfiguration config = new CorsConfiguration();
        config.setMaxAge(3600L);
        config.setAllowCredentials(true);   // 내 서버가 응답을 할 때 json을 자바스크립트에서 처리 할 수 있게 할지를 설정하는 것
        config.addAllowedOrigin("*");       // 모든 IP에 응답 하도록 한다.
        config.addAllowedHeader("*");       // 모든 header에 응답을 허용하겠다.
        config.addAllowedMethod("*");       // 모든 method에 응답을 허용하겠다.

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);
        return source;

    }
}
