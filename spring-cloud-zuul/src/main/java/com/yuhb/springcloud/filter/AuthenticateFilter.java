package com.yuhb.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.xml.internal.ws.client.ResponseContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-04-15
 */
//@Component
public class AuthenticateFilter extends ZuulFilter {
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：可以在请求被路由之前调用
        routing：在路由请求时候被调用
        post：在routing和error过滤器之后被调用
        error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过返回int值来定义过滤器的执行顺序 越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否生效，true-生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();


        HttpServletRequest request = ctx.getRequest();
        if (StringUtils.isBlank(request.getHeader("Token"))) {
            // 过滤该请求 不进行转发
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("服务认证失败");
            return null;
        }
        return null;
    }
}
