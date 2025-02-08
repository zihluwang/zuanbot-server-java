package com.onixbyte.zuan.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ApplicationProperties
 *
 * @author Zihlu Wang
 */
@ConfigurationProperties(prefix = "application.copyright")
public class ApplicationProperties {

    private String title;

    private String version;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ApplicationProperties() {
    }
}
