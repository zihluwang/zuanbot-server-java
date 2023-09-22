package wang.zihlu.zuanapi.config;

import org.springframework.beans.factory.annotation.Autowired;
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
import wang.zihlu.zuanapi.config.property.CorsProperties;

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

    private final CorsProperties corsProperties;

    @Autowired
    public SecurityConfig(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.stream(corsProperties.getAllowedOrigins()).toList());
        configuration.setAllowedMethods(Arrays.stream(corsProperties.getAllowedMethods()).map(RequestMethod::name).toList());
        configuration.setAllowedHeaders(Arrays.stream(corsProperties.getAllowedHeaders()).toList());
        configuration.setExposedHeaders(Arrays.stream(corsProperties.getExposedHeaders()).toList());

        Optional.of(corsProperties)
                .map(CorsProperties::getAllowCredentials)
                .ifPresent(configuration::setAllowCredentials);

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                // .cors((corsConfigurer -> corsConfigurer
                //         .configurationSource()))
                .authorizeHttpRequests((requestConfigurer) -> requestConfigurer
                        .anyRequest().permitAll())
                .build();
    }

}
