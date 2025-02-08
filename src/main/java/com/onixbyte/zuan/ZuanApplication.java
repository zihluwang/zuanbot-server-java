package com.onixbyte.zuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.onixbyte.zuan.config.property.ApplicationProperties;

@MapperScan("com.onixbyte.zuan.mapper")
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class ZuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuanApplication.class, args);
    }

}
