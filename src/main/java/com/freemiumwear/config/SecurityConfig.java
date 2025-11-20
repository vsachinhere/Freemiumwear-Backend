//package com.freemiumwear.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//
//import java.util.List;
//
//@Configuration
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final WhitelistProperties whitelistProperties;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuerUri;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(
//                        cors ->
//                                cors.configurationSource(
//                                        request -> {
//                                            var corsConfiguration = new CorsConfiguration();
////                                            corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000",
////                                                    "http://192.168.1.77:5173",
////                                                    "https://compliance.staging.icebolethu.co.za", //https://compliance.staging.icebolethu.co.za/
////                                                    "https://compliance.staging.api.icebolethu.co.za",
////                                                    "https://compliance.icebolethu.co.za"));
//                                            corsConfiguration.setAllowedOrigins(List.of("*"));
//                                            corsConfiguration.setAllowedMethods(
//                                                    List.of("GET", "POST", "PUT", "DELETE"));
//                                            corsConfiguration.setAllowedHeaders(List.of("*"));
////                                            corsConfiguration.setAllowCredentials(true);
//                                            return corsConfiguration;
//                                        }))
//                .authorizeHttpRequests(
//                        auth -> {
//                            List<String> whitelistArray = whitelistProperties.getPaths();
//                            if (whitelistArray != null) {
//                                for (String path : whitelistProperties.getPaths()) {
//                                    auth.requestMatchers(HttpMethod.GET, path).permitAll();
//                                    auth.requestMatchers(HttpMethod.POST, path).permitAll();
//                                    auth.requestMatchers(HttpMethod.PUT, path).permitAll();
//                                    auth.requestMatchers(HttpMethod.DELETE, path).permitAll();
////                                    auth.requestMatchers(HttpMethod.OPTIONS, path).permitAll(); // 👈 ADD THIS
////                                    auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();
//                                }
//                            }
//                            auth.anyRequest().authenticated();
//                        })
//                .oauth2ResourceServer(
//                        oauth2 ->
//                                oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
//                .sessionManagement(
//                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
//
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter =
//                new JwtGrantedAuthoritiesConverter();
//        grantedAuthoritiesConverter.setAuthoritiesClaimName("cognito:groups");
//        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
//
//        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
//        authenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
//        return authenticationConverter;
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return JwtDecoders.fromIssuerLocation(issuerUri);
//    }
//}
