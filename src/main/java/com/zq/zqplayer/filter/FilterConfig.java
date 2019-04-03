package com.zq.zqplayer.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegister1(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //注入过滤器
        registrationBean.setFilter(new TimeCostFilter());
        //拦截规则
        registrationBean.addUrlPatterns("/*");
        //过滤器名称
        registrationBean.setName("timeCostFilter1");
        //过滤器顺序 值越大，执行顺序越靠后
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE - 1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegister2(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //注入过滤器
        registrationBean.setFilter(new TimeCostFilter2());
        //拦截规则
        registrationBean.addUrlPatterns("/*");
        //过滤器名称
        registrationBean.setName("timeCostFilter2");
        //过滤器顺序 值越大，执行顺序越靠后
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

}
