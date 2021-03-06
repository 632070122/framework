package com.hengshui.filter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {


    // pre,routing,post,error
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        int i = FilterConstants.PRE_DECORATION_FILTER_ORDER;
        System.out.println("数字是"+i);
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("access-token");
        //判断是否存在,不等于null或者token是空(完整的非空判断)
        //if(token == null || token.trim().isEmpty()){ }
        if(StringUtils.isBlank(token)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());//403
        }
        return null;
    }
}
