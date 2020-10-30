package com.lemon.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hengtao.wu
 * @Date 2020/10/30 10:37
 **/
@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {

    /**
     * 过滤器类型
     * @return  前置过滤器
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序，越小越先执行
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     * 此处表示/consumer80/feign/getById会进行过滤，其他的将会放行
     * 改方法直接return true，表示所有的请求都将会放行
     * @return true 拦击， false，不拦截
     */
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if ("/consumer80/feign/getById".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }
        return false;
    }

    /**
     *对于上面方法不放行的请求，将会执行该处的拦截逻辑方法
     */
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token  = request.getParameter("token");
        if(null == token) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
