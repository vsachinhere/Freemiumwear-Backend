package com.freemiumwear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://localhost:4200/");
        configuration.addAllowedOrigin("*");
//        configuration.addAllowedOrigin("http://192.168.1.77:5173");
//        configuration.addAllowedOrigin("https://6f87a7f112f4.ngrok-free.app");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
//        configuration.setAllowCredentials(true);
        configuration.setAllowedOriginPatterns(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
//        CorsConfiguration configuration = new CorsConfiguration();

        // Allow specific origins (frontend + ngrok)
//        configuration.setAllowedOrigins(List.of(
//                "http://localhost:4200",
//                "http://192.168.1.91:5173",
//                "http://*.ngrok-free.app"
//        ));
//
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;

    }

}
