package com.lemon.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hengtao.wu
 * 用户鉴权
 * @Date 2020/10/30 10:37
 * 对于一个业务系统的用户鉴权流程来说：
 * 首先用户登录后，信息存放在token中。token存放在Redis，登录有效期为半小时。token通过http的head进行传输。
 * 当客户端请求过来后，首先经过zuul网关，通过继承了zuulFilter进行过滤。通过userId，获取token是否存在Redis中，如果不存在，则提示未登录
 * 如果存在并验证通过，则在网关层面放行，通过zuul的requestContent将head信息继续往下传递，传递给请求的服务端。
 * 一般服务端会再次进行token验证，restControllerAdvice进行拦截验证。验证通过后将token中的用户信息解析出来，然后再进入业务权限的逻辑判断
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
            //将客户端请求的头信息继续传递到服务端，默认情况下客户端请求到达网关后，网关可以获取到头信息，但是发送到微服务后，头信息就丢失了
            //requestContext.addZuulRequestHeader();
            //鉴权失败，不放行
            requestContext.setSendZuulResponse(false);
            //鉴权失败，返回响应错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //鉴权失败，返回响应
            requestContext.setResponseBody("异常信息");
        }
        return null;
    }
}
