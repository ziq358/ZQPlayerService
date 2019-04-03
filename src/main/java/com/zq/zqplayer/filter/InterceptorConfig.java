package com.zq.zqplayer.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeCostInterceptor()).addPathPatterns("/**");
    }

    //WebMvcConfigurationSupport
    //继承WebMvcConfigurationSupport后自动配置不生效的问题及如何配置拦截器
    //https://blog.csdn.net/fmwind/article/details/82832758
    //    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TimeCostInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
}
