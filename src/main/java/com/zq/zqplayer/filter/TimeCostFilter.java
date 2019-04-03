package com.zq.zqplayer.filter;

import javax.servlet.*;
import java.io.IOException;

public class TimeCostFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ziq filter 1");
        long start = System.currentTimeMillis();
        filterChain.doFilter(request,response);
        System.out.println("ziq filter 1 time cost = "+(System.currentTimeMillis()-start));
    }

}
