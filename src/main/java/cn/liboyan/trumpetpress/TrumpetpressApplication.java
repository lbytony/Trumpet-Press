package cn.liboyan.trumpetpress;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @author Li Boyan
 */
@SpringBootApplication
@MapperScan("cn.liboyan.trumpetpress.model.dao")
public class TrumpetpressApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TrumpetpressApplication.class, args);
    }
}
