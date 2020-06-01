package com.hengshui;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启网关的代理功能
public class EightGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(EightGatewayApplication.class);
    }


    // 过滤器完成权限控制
    class demo extends ZuulFilter{

        /**
         * 过滤器的类型,包含四种
         * pre 前置过滤器(主要,请求的参数处理,请求的头处理,主要对请求的处理,之后转发)
         * routing 转发完成后,执行routing,得到结果后,执行post
         * post 后置过滤器
         * error 请求发生错误时调用
         * @return
         */
        @Override
        public String filterType() {
            return null;
        }

        /**
         * 过滤器的优先级,顺序,值越大优先级越低,越小越高
         * @return
         */
        @Override
        public int filterOrder() {
            return 0;
        }

        /**
         * 是否要过滤,true过滤器会生肖
         * @return
         */
        @Override
        public boolean shouldFilter() {
            return false;
        }

        /**
         * 过滤的逻辑
         * @return
         * @throws ZuulException
         */
        @Override
        public Object run() throws ZuulException {
            return null;
        }
    }
}