package com.onejava.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class AddRequestHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader("x-location", "IN");
        context.addZuulRequestHeader("Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aW5heSIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJVU0VSIn1dLCJleHAiOjE2MDM4NzgxNTMsImlhdCI6MTYwMzg3NzU1M30.VYLWeIUIjkTXyQZWNdMDJc6-qzgX3gSb-drCd88lz2Y");
        return null;
    }
}
