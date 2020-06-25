package cn.liboyan.trumpetpress.config;

import cn.liboyan.trumpetpress.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/tp-admin/**")
                .excludePathPatterns("/tp-admin")
                .excludePathPatterns("/tp-admin/login");
    }
}
