package com.onixbyte.zuan.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CorsConfigProp
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@ConfigurationProperties("application.cors")
public class CorsProperties {

    private Boolean allowCredentials;

    private String[] allowedOrigins = {"*"};

    private String[] allowedHeaders;

    private RequestMethod[] allowedMethods = {
            RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.PATCH,
            RequestMethod.DELETE
    };

    private String[] exposedHeaders;

    private Long maxAge;

    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public String[] getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(String[] allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public RequestMethod[] getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(RequestMethod[] allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public String[] getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(String[] exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }
}
