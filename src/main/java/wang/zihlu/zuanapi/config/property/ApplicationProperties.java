package wang.zihlu.zuanapi.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ApplicationProperties
 *
 * @author Zihlu Wang
 */
@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String title;

    private String version;

}
