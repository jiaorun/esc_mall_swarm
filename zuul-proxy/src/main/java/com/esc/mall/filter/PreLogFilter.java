package com.esc.mall.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul 过滤器
 *
 * @author jiaorun
 * @date 2022/1/10 17:03
 **/
@Component
public class PreLogFilter extends ZuulFilter {

    private Logger LOGGER = LoggerFactory.getLogger(ZuulFilter.class);

    /**
     * 过滤器类型，有pre、routing、post、error四种
     *
     * @author jiaorun
     * @data 2022/1/10 17:04
     * @return java.lang.String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，数值越小优先级越高
     *
     * @author jiaorun
     * @data 2022/1/10 17:04
     * @return int
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否进行过滤，返回true则进行过滤
     *
     * @author jiaorun
     * @data 2022/1/10 17:05
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 自定义的过滤器逻辑，当shouldFilter()返回true时会执行
     *
     * @author jiaorun
     * @data 2022/1/10 17:06
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        LOGGER.info("................................");
        LOGGER.info("Remote host:{}, method:{}, uri:{}", host, method, uri);
        return null;
    }
}
