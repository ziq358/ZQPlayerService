package com.zq.zqplayer.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "timeCostFilterUseWebFilter2", urlPatterns = "/*")
@Order(FilterRegistrationBean.LOWEST_PRECEDENCE - 3)
public class TimeCostFilterUseWebFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ziq TimeCostFilterUseWebFilter2");
        long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println("ziq TimeCostFilterUseWebFilter2 time cost = "+(System.currentTimeMillis()-start));
    }
}
