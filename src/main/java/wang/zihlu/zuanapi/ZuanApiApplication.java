package wang.zihlu.zuanapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("wang.zihlu.zuanapi.mapper")
@SpringBootApplication
public class ZuanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuanApiApplication.class, args);
    }

}
