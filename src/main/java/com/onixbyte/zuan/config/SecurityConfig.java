package com.onixbyte.zuan.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.onixbyte.zuan.config.property.CorsProperties;

import java.util.Arrays;
import java.util.Optional;

/**
 * SecurityConfig
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@EnableWebSecurity
@Configuration
@EnableConfigurationProperties({CorsProperties.class})
public class SecurityConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(CorsProperties corsProperties) {
        var configuration = new CorsConfiguration();

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getAllowedOrigins)
                .map((allowedOrigins) -> Arrays.stream(allowedOrigins).toList())
                .ifPresent(configuration::setAllowedOrigins);

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getAllowedMethods)
                .map((allowedMethods) -> Arrays.stream(allowedMethods)
                        .map(RequestMethod::name)
                        .toList())
                .ifPresent(configuration::setAllowedMethods);

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getAllowedHeaders)
                .map((allowedHeaders) -> Arrays.stream(allowedHeaders)
                        .toList())
                .ifPresent(configuration::setAllowedMethods);

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getAllowCredentials)
                .ifPresent(configuration::setAllowCredentials);

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getMaxAge)
                .ifPresent(configuration::setMaxAge);

        Optional.ofNullable(corsProperties)
                .map(CorsProperties::getExposedHeaders)
                .map((exposedHeaders) -> Arrays.stream(exposedHeaders).toList())
                .ifPresent(configuration::setExposedHeaders);

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   CorsConfigurationSource corsConfigurationSource) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors((corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource)))
                .authorizeHttpRequests((requestConfigurer) -> requestConfigurer
                        .anyRequest().permitAll())
                .build();
    }

}
