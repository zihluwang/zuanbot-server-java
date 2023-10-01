package wang.zihlu.zuanapi.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CorsConfigProp
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@Data
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

}
