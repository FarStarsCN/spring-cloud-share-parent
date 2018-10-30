package com.wangzc.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * 只需要继承ZuulFilter就可以起到过滤的功能
 *
 * @author wang_zc
 * @date 2018/10/22
 */
@Component
public class MyFilter extends ZuulFilter {

    /***
     * 过滤器的类型-> 一共有四种：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @author wang_zc
     * @return java.lang.String
     */
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
        // 返回true代表过滤，可以写逻辑判断是否过滤
        return true;
    }

    /**
     * 具体的过滤逻辑
     *
     * @author wang_zc
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        if (context.getRequest().getParameter("token") == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("error, token is empty!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
