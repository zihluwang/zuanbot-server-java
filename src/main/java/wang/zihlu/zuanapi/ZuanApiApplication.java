package wang.zihlu.zuanapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import wang.zihlu.zuanapi.config.property.ApplicationProperties;

@MapperScan("wang.zihlu.zuanapi.mapper")
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class ZuanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuanApiApplication.class, args);
    }

}
